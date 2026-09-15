package drr.ingest.fpml.recordkeeping.reportableinfo.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.doc.PartyRelationshipType;
import fpml.consolidated.doc.PartyTradeInformation;
import fpml.consolidated.doc.ReportingRegime;
import fpml.consolidated.doc.TradeCategory;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapPartyTradeInformationToIntragroup.MapPartyTradeInformationToIntragroupDefault.class)
public abstract class MapPartyTradeInformationToIntragroup implements RosettaFunction {

	/**
	* @param partyTradeInformation 
	* @return isIntraGroup 
	*/
	public Boolean evaluate(List<? extends PartyTradeInformation> partyTradeInformation) {
		Boolean isIntraGroup = doEvaluate(partyTradeInformation);
		
		return isIntraGroup;
	}

	protected abstract Boolean doEvaluate(List<? extends PartyTradeInformation> partyTradeInformation);

	protected abstract MapperS<String> dtccIntraGroupScheme(List<? extends PartyTradeInformation> partyTradeInformation);

	protected abstract MapperC<? extends TradeCategory> categorySchemeIsDtcc(List<? extends PartyTradeInformation> partyTradeInformation);

	protected abstract MapperS<? extends TradeCategory> categoryValueExistsAndSchemeMatches(List<? extends PartyTradeInformation> partyTradeInformation);

	protected abstract MapperS<Boolean> isIntraGroupByCategory(List<? extends PartyTradeInformation> partyTradeInformation);

	protected abstract MapperC<String> isIntragroupByTradePartyRelationshipType(List<? extends PartyTradeInformation> partyTradeInformation);

	public static class MapPartyTradeInformationToIntragroupDefault extends MapPartyTradeInformationToIntragroup {
		@Override
		protected Boolean doEvaluate(List<? extends PartyTradeInformation> partyTradeInformation) {
			if (partyTradeInformation == null) {
				partyTradeInformation = Collections.emptyList();
			}
			Boolean isIntraGroup = null;
			return assignOutput(isIntraGroup, partyTradeInformation);
		}
		
		protected Boolean assignOutput(Boolean isIntraGroup, List<? extends PartyTradeInformation> partyTradeInformation) {
			if (exists(isIntraGroupByCategory(partyTradeInformation)).getOrDefault(false)) {
				isIntraGroup = isIntraGroupByCategory(partyTradeInformation).get();
			} else if (exists(isIntragroupByTradePartyRelationshipType(partyTradeInformation)).getOrDefault(false)) {
				isIntraGroup = true;
			} else {
				isIntraGroup = null;
			}
			
			return isIntraGroup;
		}
		
		@Override
		protected MapperS<String> dtccIntraGroupScheme(List<? extends PartyTradeInformation> partyTradeInformation) {
			return MapperS.of("http://www.dtcc.com/intragroup");
		}
		
		@Override
		protected MapperC<? extends TradeCategory> categorySchemeIsDtcc(List<? extends PartyTradeInformation> partyTradeInformation) {
			return MapperC.<PartyTradeInformation>of(partyTradeInformation).<TradeCategory>mapC("getCategory", _partyTradeInformation -> _partyTradeInformation.getCategory())
				.filterItemNullSafe(item -> areEqual(item.<String>map("getCategoryScheme", tradeCategory -> tradeCategory.getCategoryScheme()), dtccIntraGroupScheme(partyTradeInformation), CardinalityOperator.All).get());
		}
		
		@Override
		protected MapperS<? extends TradeCategory> categoryValueExistsAndSchemeMatches(List<? extends PartyTradeInformation> partyTradeInformation) {
			final MapperC<TradeCategory> thenArg = MapperC.<PartyTradeInformation>of(partyTradeInformation).<TradeCategory>mapC("getCategory", _partyTradeInformation -> _partyTradeInformation.getCategory())
				.filterItemNullSafe(item -> exists(item.<String>map("getValue", tradeCategory -> tradeCategory.getValue())).andNullSafe(areEqual(item.<String>map("getCategoryScheme", tradeCategory -> tradeCategory.getCategoryScheme()), dtccIntraGroupScheme(partyTradeInformation), CardinalityOperator.All)).get());
			return thenArg
				.first();
		}
		
		@Override
		protected MapperS<Boolean> isIntraGroupByCategory(List<? extends PartyTradeInformation> partyTradeInformation) {
			if (exists(categoryValueExistsAndSchemeMatches(partyTradeInformation)).getOrDefault(false)) {
				return categoryValueExistsAndSchemeMatches(partyTradeInformation).<String>map("getValue", tradeCategory -> tradeCategory.getValue())
					.mapSingleToItem(item -> areEqual(item, MapperS.of("True"), CardinalityOperator.All).asMapper());
			}
			if (exists(categorySchemeIsDtcc(partyTradeInformation)).getOrDefault(false)) {
				return MapperS.of(true);
			}
			return MapperS.<Boolean>ofNull();
		}
		
		@Override
		protected MapperC<String> isIntragroupByTradePartyRelationshipType(List<? extends PartyTradeInformation> partyTradeInformation) {
			return MapperC.<PartyTradeInformation>of(partyTradeInformation).<ReportingRegime>mapC("getReportingRegime", _partyTradeInformation -> _partyTradeInformation.getReportingRegime()).<PartyRelationshipType>map("getTradePartyRelationshipType", reportingRegime -> reportingRegime.getTradePartyRelationshipType()).<String>map("getValue", partyRelationshipType -> partyRelationshipType.getValue())
				.filterItemNullSafe(item -> areEqual(item, MapperS.of("Intragroup"), CardinalityOperator.All).get());
		}
	}
}
