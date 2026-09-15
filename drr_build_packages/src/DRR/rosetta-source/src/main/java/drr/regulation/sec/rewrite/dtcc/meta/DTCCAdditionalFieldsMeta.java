package drr.regulation.sec.rewrite.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.sec.rewrite.dtcc.DTCCAdditionalFields;
import drr.regulation.sec.rewrite.dtcc.validation.DTCCAdditionalFieldsTypeFormatValidator;
import drr.regulation.sec.rewrite.dtcc.validation.DTCCAdditionalFieldsValidator;
import drr.regulation.sec.rewrite.dtcc.validation.exists.DTCCAdditionalFieldsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=DTCCAdditionalFields.class)
public class DTCCAdditionalFieldsMeta implements RosettaMetaData<DTCCAdditionalFields> {

	@Override
	public List<Validator<? super DTCCAdditionalFields>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DTCCAdditionalFields, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DTCCAdditionalFields> validator(ValidatorFactory factory) {
		return factory.<DTCCAdditionalFields>create(DTCCAdditionalFieldsValidator.class);
	}

	@Override
	public Validator<? super DTCCAdditionalFields> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DTCCAdditionalFields>create(DTCCAdditionalFieldsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DTCCAdditionalFields> validator() {
		return new DTCCAdditionalFieldsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DTCCAdditionalFields> typeFormatValidator() {
		return new DTCCAdditionalFieldsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DTCCAdditionalFields, Set<String>> onlyExistsValidator() {
		return new DTCCAdditionalFieldsOnlyExistsValidator();
	}
}
