package cdm.ingest.fpml.confirmation.product.creditdefaultswap.functions;

import cdm.base.staticdata.asset.common.InstrumentTypeEnum;
import cdm.base.staticdata.asset.common.Security;
import cdm.ingest.fpml.confirmation.party.functions.MapLegalEntityReference;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapIdentifiedAssetToSecurity;
import cdm.product.asset.ReferenceObligation;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.Bond;
import fpml.consolidated.asset.ConvertibleBond;
import fpml.consolidated.asset.Loan;
import fpml.consolidated.asset.Mortgage;
import fpml.consolidated.asset.UnderlyingAsset;
import fpml.consolidated.shared.CreditSeniority;
import fpml.consolidated.shared.ExchangeId;
import fpml.consolidated.shared.LegalEntityReference;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapReferenceObligation.MapReferenceObligationDefault.class)
public abstract class MapReferenceObligation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapIdentifiedAssetToSecurity mapIdentifiedAssetToSecurity;
	@Inject protected MapLegalEntityReference mapLegalEntityReference;

	/**
	* @param fpmlReferenceObligation 
	* @return referenceObligation 
	*/
	public ReferenceObligation evaluate(fpml.consolidated.cd.ReferenceObligation fpmlReferenceObligation) {
		ReferenceObligation.ReferenceObligationBuilder referenceObligationBuilder = doEvaluate(fpmlReferenceObligation);
		
		final ReferenceObligation referenceObligation;
		if (referenceObligationBuilder == null) {
			referenceObligation = null;
		} else {
			referenceObligation = referenceObligationBuilder.build();
			objectValidator.validate(ReferenceObligation.class, referenceObligation);
		}
		
		return referenceObligation;
	}

	protected abstract ReferenceObligation.ReferenceObligationBuilder doEvaluate(fpml.consolidated.cd.ReferenceObligation fpmlReferenceObligation);

	protected abstract MapperS<? extends UnderlyingAsset> debtAsset(fpml.consolidated.cd.ReferenceObligation fpmlReferenceObligation);

	protected abstract MapperS<String> seniority(fpml.consolidated.cd.ReferenceObligation fpmlReferenceObligation);

	public static class MapReferenceObligationDefault extends MapReferenceObligation {
		@Override
		protected ReferenceObligation.ReferenceObligationBuilder doEvaluate(fpml.consolidated.cd.ReferenceObligation fpmlReferenceObligation) {
			ReferenceObligation.ReferenceObligationBuilder referenceObligation = ReferenceObligation.builder();
			return assignOutput(referenceObligation, fpmlReferenceObligation);
		}
		
		protected ReferenceObligation.ReferenceObligationBuilder assignOutput(ReferenceObligation.ReferenceObligationBuilder referenceObligation, fpml.consolidated.cd.ReferenceObligation fpmlReferenceObligation) {
			Security ifThenElseResult = null;
			if (exists(debtAsset(fpmlReferenceObligation)).getOrDefault(false)) {
				ifThenElseResult = mapIdentifiedAssetToSecurity.evaluate(debtAsset(fpmlReferenceObligation).get(), null, Collections.<ExchangeId>emptyList(), InstrumentTypeEnum.DEBT, seniority(fpmlReferenceObligation).get());
			}
			referenceObligation = toBuilder(ReferenceObligation.builder()
				.setSecurity(ifThenElseResult)
				.setPrimaryObligorReference(mapLegalEntityReference.evaluate(MapperS.of(fpmlReferenceObligation).<LegalEntityReference>map("getPrimaryObligorReference", _referenceObligation -> _referenceObligation.getPrimaryObligorReference()).get()))
				.build());
			
			return Optional.ofNullable(referenceObligation)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends UnderlyingAsset> debtAsset(fpml.consolidated.cd.ReferenceObligation fpmlReferenceObligation) {
			if (exists(MapperS.of(fpmlReferenceObligation).<Bond>map("getBond", referenceObligation -> referenceObligation.getBond())).getOrDefault(false)) {
				return MapperS.of(fpmlReferenceObligation).<Bond>map("getBond", referenceObligation -> referenceObligation.getBond());
			}
			if (exists(MapperS.of(fpmlReferenceObligation).<ConvertibleBond>map("getConvertibleBond", referenceObligation -> referenceObligation.getConvertibleBond())).getOrDefault(false)) {
				return MapperS.of(fpmlReferenceObligation).<ConvertibleBond>map("getConvertibleBond", referenceObligation -> referenceObligation.getConvertibleBond());
			}
			if (exists(MapperS.of(fpmlReferenceObligation).<Loan>map("getLoan", referenceObligation -> referenceObligation.getLoan())).getOrDefault(false)) {
				return MapperS.of(fpmlReferenceObligation).<Loan>map("getLoan", referenceObligation -> referenceObligation.getLoan());
			}
			if (exists(MapperS.of(fpmlReferenceObligation).<Mortgage>map("getMortgage", referenceObligation -> referenceObligation.getMortgage())).getOrDefault(false)) {
				return MapperS.of(fpmlReferenceObligation).<Mortgage>map("getMortgage", referenceObligation -> referenceObligation.getMortgage());
			}
			return MapperS.<UnderlyingAsset>ofNull();
		}
		
		@Override
		protected MapperS<String> seniority(fpml.consolidated.cd.ReferenceObligation fpmlReferenceObligation) {
			if (exists(MapperS.of(fpmlReferenceObligation).<Bond>map("getBond", referenceObligation -> referenceObligation.getBond())).getOrDefault(false)) {
				return MapperS.of(fpmlReferenceObligation).<Bond>map("getBond", referenceObligation -> referenceObligation.getBond()).<CreditSeniority>map("getSeniority", bond -> bond.getSeniority()).<String>map("getValue", creditSeniority -> creditSeniority.getValue());
			}
			return MapperS.<String>ofNull();
		}
	}
}
