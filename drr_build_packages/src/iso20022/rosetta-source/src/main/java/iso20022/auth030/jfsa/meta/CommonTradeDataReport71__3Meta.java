package iso20022.auth030.jfsa.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.CommonTradeDataReport71__3;
import iso20022.auth030.jfsa.validation.CommonTradeDataReport71__3TypeFormatValidator;
import iso20022.auth030.jfsa.validation.CommonTradeDataReport71__3Validator;
import iso20022.auth030.jfsa.validation.exists.CommonTradeDataReport71__3OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommonTradeDataReport71__3.class)
public class CommonTradeDataReport71__3Meta implements RosettaMetaData<CommonTradeDataReport71__3> {

	@Override
	public List<Validator<? super CommonTradeDataReport71__3>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommonTradeDataReport71__3, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommonTradeDataReport71__3> validator(ValidatorFactory factory) {
		return factory.<CommonTradeDataReport71__3>create(CommonTradeDataReport71__3Validator.class);
	}

	@Override
	public Validator<? super CommonTradeDataReport71__3> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommonTradeDataReport71__3>create(CommonTradeDataReport71__3TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommonTradeDataReport71__3> validator() {
		return new CommonTradeDataReport71__3Validator();
	}

	@Deprecated
	@Override
	public Validator<? super CommonTradeDataReport71__3> typeFormatValidator() {
		return new CommonTradeDataReport71__3TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommonTradeDataReport71__3, Set<String>> onlyExistsValidator() {
		return new CommonTradeDataReport71__3OnlyExistsValidator();
	}
}
