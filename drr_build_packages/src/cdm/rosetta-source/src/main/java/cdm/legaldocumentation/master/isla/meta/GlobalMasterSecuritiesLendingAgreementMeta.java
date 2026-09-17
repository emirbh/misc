package cdm.legaldocumentation.master.isla.meta;

import cdm.legaldocumentation.master.isla.GlobalMasterSecuritiesLendingAgreement;
import cdm.legaldocumentation.master.isla.validation.GlobalMasterSecuritiesLendingAgreementTypeFormatValidator;
import cdm.legaldocumentation.master.isla.validation.GlobalMasterSecuritiesLendingAgreementValidator;
import cdm.legaldocumentation.master.isla.validation.exists.GlobalMasterSecuritiesLendingAgreementOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=GlobalMasterSecuritiesLendingAgreement.class)
public class GlobalMasterSecuritiesLendingAgreementMeta implements RosettaMetaData<GlobalMasterSecuritiesLendingAgreement> {

	@Override
	public List<Validator<? super GlobalMasterSecuritiesLendingAgreement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GlobalMasterSecuritiesLendingAgreement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super GlobalMasterSecuritiesLendingAgreement> validator(ValidatorFactory factory) {
		return factory.<GlobalMasterSecuritiesLendingAgreement>create(GlobalMasterSecuritiesLendingAgreementValidator.class);
	}

	@Override
	public Validator<? super GlobalMasterSecuritiesLendingAgreement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<GlobalMasterSecuritiesLendingAgreement>create(GlobalMasterSecuritiesLendingAgreementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super GlobalMasterSecuritiesLendingAgreement> validator() {
		return new GlobalMasterSecuritiesLendingAgreementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super GlobalMasterSecuritiesLendingAgreement> typeFormatValidator() {
		return new GlobalMasterSecuritiesLendingAgreementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GlobalMasterSecuritiesLendingAgreement, Set<String>> onlyExistsValidator() {
		return new GlobalMasterSecuritiesLendingAgreementOnlyExistsValidator();
	}
}
