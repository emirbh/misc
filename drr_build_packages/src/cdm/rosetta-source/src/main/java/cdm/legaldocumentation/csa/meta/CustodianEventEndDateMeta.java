package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.CustodianEventEndDate;
import cdm.legaldocumentation.csa.validation.CustodianEventEndDateTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.CustodianEventEndDateValidator;
import cdm.legaldocumentation.csa.validation.exists.CustodianEventEndDateOnlyExistsValidator;
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
@RosettaMeta(model=CustodianEventEndDate.class)
public class CustodianEventEndDateMeta implements RosettaMetaData<CustodianEventEndDate> {

	@Override
	public List<Validator<? super CustodianEventEndDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CustodianEventEndDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CustodianEventEndDate> validator(ValidatorFactory factory) {
		return factory.<CustodianEventEndDate>create(CustodianEventEndDateValidator.class);
	}

	@Override
	public Validator<? super CustodianEventEndDate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CustodianEventEndDate>create(CustodianEventEndDateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CustodianEventEndDate> validator() {
		return new CustodianEventEndDateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CustodianEventEndDate> typeFormatValidator() {
		return new CustodianEventEndDateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CustodianEventEndDate, Set<String>> onlyExistsValidator() {
		return new CustodianEventEndDateOnlyExistsValidator();
	}
}
