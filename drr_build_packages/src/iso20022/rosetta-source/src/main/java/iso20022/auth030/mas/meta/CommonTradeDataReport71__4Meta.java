package iso20022.auth030.mas.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.mas.CommonTradeDataReport71__4;
import iso20022.auth030.mas.validation.CommonTradeDataReport71__4TypeFormatValidator;
import iso20022.auth030.mas.validation.CommonTradeDataReport71__4Validator;
import iso20022.auth030.mas.validation.exists.CommonTradeDataReport71__4OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommonTradeDataReport71__4.class)
public class CommonTradeDataReport71__4Meta implements RosettaMetaData<CommonTradeDataReport71__4> {

	@Override
	public List<Validator<? super CommonTradeDataReport71__4>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommonTradeDataReport71__4, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommonTradeDataReport71__4> validator(ValidatorFactory factory) {
		return factory.<CommonTradeDataReport71__4>create(CommonTradeDataReport71__4Validator.class);
	}

	@Override
	public Validator<? super CommonTradeDataReport71__4> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommonTradeDataReport71__4>create(CommonTradeDataReport71__4TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommonTradeDataReport71__4> validator() {
		return new CommonTradeDataReport71__4Validator();
	}

	@Deprecated
	@Override
	public Validator<? super CommonTradeDataReport71__4> typeFormatValidator() {
		return new CommonTradeDataReport71__4TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommonTradeDataReport71__4, Set<String>> onlyExistsValidator() {
		return new CommonTradeDataReport71__4OnlyExistsValidator();
	}
}
