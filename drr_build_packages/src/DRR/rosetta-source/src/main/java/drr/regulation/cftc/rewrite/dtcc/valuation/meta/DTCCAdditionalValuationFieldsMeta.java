package drr.regulation.cftc.rewrite.dtcc.valuation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.cftc.rewrite.dtcc.valuation.DTCCAdditionalValuationFields;
import drr.regulation.cftc.rewrite.dtcc.valuation.validation.DTCCAdditionalValuationFieldsTypeFormatValidator;
import drr.regulation.cftc.rewrite.dtcc.valuation.validation.DTCCAdditionalValuationFieldsValidator;
import drr.regulation.cftc.rewrite.dtcc.valuation.validation.exists.DTCCAdditionalValuationFieldsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=DTCCAdditionalValuationFields.class)
public class DTCCAdditionalValuationFieldsMeta implements RosettaMetaData<DTCCAdditionalValuationFields> {

	@Override
	public List<Validator<? super DTCCAdditionalValuationFields>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DTCCAdditionalValuationFields, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DTCCAdditionalValuationFields> validator(ValidatorFactory factory) {
		return factory.<DTCCAdditionalValuationFields>create(DTCCAdditionalValuationFieldsValidator.class);
	}

	@Override
	public Validator<? super DTCCAdditionalValuationFields> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DTCCAdditionalValuationFields>create(DTCCAdditionalValuationFieldsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DTCCAdditionalValuationFields> validator() {
		return new DTCCAdditionalValuationFieldsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DTCCAdditionalValuationFields> typeFormatValidator() {
		return new DTCCAdditionalValuationFieldsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DTCCAdditionalValuationFields, Set<String>> onlyExistsValidator() {
		return new DTCCAdditionalValuationFieldsOnlyExistsValidator();
	}
}
