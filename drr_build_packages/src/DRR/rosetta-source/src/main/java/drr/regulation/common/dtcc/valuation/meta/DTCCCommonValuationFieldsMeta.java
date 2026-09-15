package drr.regulation.common.dtcc.valuation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.dtcc.valuation.DTCCCommonValuationFields;
import drr.regulation.common.dtcc.valuation.validation.DTCCCommonValuationFieldsTypeFormatValidator;
import drr.regulation.common.dtcc.valuation.validation.DTCCCommonValuationFieldsValidator;
import drr.regulation.common.dtcc.valuation.validation.exists.DTCCCommonValuationFieldsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=DTCCCommonValuationFields.class)
public class DTCCCommonValuationFieldsMeta implements RosettaMetaData<DTCCCommonValuationFields> {

	@Override
	public List<Validator<? super DTCCCommonValuationFields>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DTCCCommonValuationFields, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DTCCCommonValuationFields> validator(ValidatorFactory factory) {
		return factory.<DTCCCommonValuationFields>create(DTCCCommonValuationFieldsValidator.class);
	}

	@Override
	public Validator<? super DTCCCommonValuationFields> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DTCCCommonValuationFields>create(DTCCCommonValuationFieldsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DTCCCommonValuationFields> validator() {
		return new DTCCCommonValuationFieldsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DTCCCommonValuationFields> typeFormatValidator() {
		return new DTCCCommonValuationFieldsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DTCCCommonValuationFields, Set<String>> onlyExistsValidator() {
		return new DTCCCommonValuationFieldsOnlyExistsValidator();
	}
}
