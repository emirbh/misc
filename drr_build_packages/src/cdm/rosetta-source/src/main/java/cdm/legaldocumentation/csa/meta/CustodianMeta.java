package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.Custodian;
import cdm.legaldocumentation.csa.validation.CustodianTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.CustodianValidator;
import cdm.legaldocumentation.csa.validation.exists.CustodianOnlyExistsValidator;
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
@RosettaMeta(model=Custodian.class)
public class CustodianMeta implements RosettaMetaData<Custodian> {

	@Override
	public List<Validator<? super Custodian>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Custodian, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Custodian> validator(ValidatorFactory factory) {
		return factory.<Custodian>create(CustodianValidator.class);
	}

	@Override
	public Validator<? super Custodian> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Custodian>create(CustodianTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Custodian> validator() {
		return new CustodianValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Custodian> typeFormatValidator() {
		return new CustodianTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Custodian, Set<String>> onlyExistsValidator() {
		return new CustodianOnlyExistsValidator();
	}
}
