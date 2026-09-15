package drr.ingest.fpml.recordkeeping.reportableinfo.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.CorporateSector;
import drr.regulation.common.FinancialSectorEnum;
import drr.regulation.common.NonFinancialSector;
import drr.regulation.common.NonFinancialSectorEnum;
import fpml.consolidated.shared.IndustryClassification;
import fpml.consolidated.shared.Party;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapCorporateSector.MapCorporateSectorDefault.class)
public abstract class MapCorporateSector implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetOrdinalForNonFinancialSectorEnum getOrdinalForNonFinancialSectorEnum;

	/**
	* @param corporateSectorScheme 
	* @param fpmlParty 
	* @return corporateSector 
	*/
	public CorporateSector evaluate(String corporateSectorScheme, Party fpmlParty) {
		CorporateSector.CorporateSectorBuilder corporateSectorBuilder = doEvaluate(corporateSectorScheme, fpmlParty);
		
		final CorporateSector corporateSector;
		if (corporateSectorBuilder == null) {
			corporateSector = null;
		} else {
			corporateSector = corporateSectorBuilder.build();
			objectValidator.validate(CorporateSector.class, corporateSector);
		}
		
		return corporateSector;
	}

	protected abstract CorporateSector.CorporateSectorBuilder doEvaluate(String corporateSectorScheme, Party fpmlParty);

	protected abstract MapperC<? extends IndustryClassification> classification(String corporateSectorScheme, Party fpmlParty);

	protected abstract MapperC<FinancialSectorEnum> financialSector(String corporateSectorScheme, Party fpmlParty);

	protected abstract MapperC<? extends NonFinancialSector> nonFinancialSector(String corporateSectorScheme, Party fpmlParty);

	public static class MapCorporateSectorDefault extends MapCorporateSector {
		@Override
		protected CorporateSector.CorporateSectorBuilder doEvaluate(String corporateSectorScheme, Party fpmlParty) {
			CorporateSector.CorporateSectorBuilder corporateSector = CorporateSector.builder();
			return assignOutput(corporateSector, corporateSectorScheme, fpmlParty);
		}
		
		protected CorporateSector.CorporateSectorBuilder assignOutput(CorporateSector.CorporateSectorBuilder corporateSector, String corporateSectorScheme, Party fpmlParty) {
			corporateSector = toBuilder(CorporateSector.builder()
				.setFinancialSector(financialSector(corporateSectorScheme, fpmlParty).getMulti())
				.setNonFinancialSector(new ArrayList<>(nonFinancialSector(corporateSectorScheme, fpmlParty).getMulti()))
				.build());
			
			return Optional.ofNullable(corporateSector)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends IndustryClassification> classification(String corporateSectorScheme, Party fpmlParty) {
			return MapperS.of(fpmlParty).<IndustryClassification>mapC("getClassification", party -> party.getClassification())
				.filterItemNullSafe(item -> areEqual(item.<String>map("getIndustryClassificationScheme", industryClassification -> industryClassification.getIndustryClassificationScheme()), MapperS.of(corporateSectorScheme), CardinalityOperator.All).get());
		}
		
		@Override
		protected MapperC<FinancialSectorEnum> financialSector(String corporateSectorScheme, Party fpmlParty) {
			final MapperC<? extends IndustryClassification> thenArg = classification(corporateSectorScheme, fpmlParty);
			return thenArg
				.mapItem(item -> item.<String>map("getValue", industryClassification -> industryClassification.getValue()).checkedMap("to-enum", FinancialSectorEnum::fromDisplayName, IllegalArgumentException.class));
		}
		
		@Override
		protected MapperC<? extends NonFinancialSector> nonFinancialSector(String corporateSectorScheme, Party fpmlParty) {
			final MapperC<String> thenArg = classification(corporateSectorScheme, fpmlParty).<String>map("getValue", industryClassification -> industryClassification.getValue())
				.filterItemNullSafe(item -> exists(item).get());
			return thenArg
				.mapItem(item -> MapperS.of(NonFinancialSector.builder()
					.setNonFinancialSectorIndicator(item.checkedMap("to-enum", NonFinancialSectorEnum::fromDisplayName, IllegalArgumentException.class).get())
					.setOrdinal(getOrdinalForNonFinancialSectorEnum.evaluate(item.checkedMap("to-enum", NonFinancialSectorEnum::fromDisplayName, IllegalArgumentException.class).get()))
					.build()));
		}
	}
}
