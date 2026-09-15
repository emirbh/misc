package cdm.ingest.fpml.confirmation.legal.functions;

import cdm.ingest.fpml.confirmation.other.functions.MapCreditSupportAgreementTypeEnum;
import cdm.product.collateral.CreditSupportAgreementTypeEnum;
import cdm.product.collateral.metafields.FieldWithMetaCreditSupportAgreementTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.MetaFields;
import fpml.consolidated.shared.CreditSupportAgreementType;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCreditSupportAgreementTypeEnumWithScheme.MapCreditSupportAgreementTypeEnumWithSchemeDefault.class)
public abstract class MapCreditSupportAgreementTypeEnumWithScheme implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCreditSupportAgreementTypeEnum mapCreditSupportAgreementTypeEnum;

	/**
	* @param fpmlCreditSupportAgreementType 
	* @return creditSupportAgreementTypeEnum 
	*/
	public FieldWithMetaCreditSupportAgreementTypeEnum evaluate(CreditSupportAgreementType fpmlCreditSupportAgreementType) {
		FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilder creditSupportAgreementTypeEnumBuilder = doEvaluate(fpmlCreditSupportAgreementType);
		
		final FieldWithMetaCreditSupportAgreementTypeEnum creditSupportAgreementTypeEnum;
		if (creditSupportAgreementTypeEnumBuilder == null) {
			creditSupportAgreementTypeEnum = null;
		} else {
			creditSupportAgreementTypeEnum = creditSupportAgreementTypeEnumBuilder.build();
			objectValidator.validate(FieldWithMetaCreditSupportAgreementTypeEnum.class, creditSupportAgreementTypeEnum);
		}
		
		return creditSupportAgreementTypeEnum;
	}

	protected abstract FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilder doEvaluate(CreditSupportAgreementType fpmlCreditSupportAgreementType);

	public static class MapCreditSupportAgreementTypeEnumWithSchemeDefault extends MapCreditSupportAgreementTypeEnumWithScheme {
		@Override
		protected FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilder doEvaluate(CreditSupportAgreementType fpmlCreditSupportAgreementType) {
			FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilder creditSupportAgreementTypeEnum = FieldWithMetaCreditSupportAgreementTypeEnum.builder();
			return assignOutput(creditSupportAgreementTypeEnum, fpmlCreditSupportAgreementType);
		}
		
		protected FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilder assignOutput(FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilder creditSupportAgreementTypeEnum, CreditSupportAgreementType fpmlCreditSupportAgreementType) {
			final CreditSupportAgreementTypeEnum withMetaArgument = mapCreditSupportAgreementTypeEnum.evaluate(MapperS.of(fpmlCreditSupportAgreementType).<String>map("getValue", creditSupportAgreementType -> creditSupportAgreementType.getValue()).get());
			creditSupportAgreementTypeEnum = toBuilder(FieldWithMetaCreditSupportAgreementTypeEnum.builder().setValue(withMetaArgument).setMeta(MetaFields.builder().setScheme(MapperS.of(fpmlCreditSupportAgreementType).<String>map("getCreditSupportAgreementTypeScheme", creditSupportAgreementType -> creditSupportAgreementType.getCreditSupportAgreementTypeScheme()).get())));
			
			return Optional.ofNullable(creditSupportAgreementTypeEnum)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
