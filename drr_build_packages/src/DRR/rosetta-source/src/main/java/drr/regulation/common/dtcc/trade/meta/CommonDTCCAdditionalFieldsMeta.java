package drr.regulation.common.dtcc.trade.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.dtcc.trade.CommonDTCCAdditionalFields;
import drr.regulation.common.dtcc.trade.validation.CommonDTCCAdditionalFieldsTypeFormatValidator;
import drr.regulation.common.dtcc.trade.validation.CommonDTCCAdditionalFieldsValidator;
import drr.regulation.common.dtcc.trade.validation.exists.CommonDTCCAdditionalFieldsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=CommonDTCCAdditionalFields.class)
public class CommonDTCCAdditionalFieldsMeta implements RosettaMetaData<CommonDTCCAdditionalFields> {

	@Override
	public List<Validator<? super CommonDTCCAdditionalFields>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommonDTCCAdditionalFields, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommonDTCCAdditionalFields> validator(ValidatorFactory factory) {
		return factory.<CommonDTCCAdditionalFields>create(CommonDTCCAdditionalFieldsValidator.class);
	}

	@Override
	public Validator<? super CommonDTCCAdditionalFields> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommonDTCCAdditionalFields>create(CommonDTCCAdditionalFieldsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommonDTCCAdditionalFields> validator() {
		return new CommonDTCCAdditionalFieldsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommonDTCCAdditionalFields> typeFormatValidator() {
		return new CommonDTCCAdditionalFieldsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommonDTCCAdditionalFields, Set<String>> onlyExistsValidator() {
		return new CommonDTCCAdditionalFieldsOnlyExistsValidator();
	}
}
