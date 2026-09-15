package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.CommonTradeDataReport69__1;
import iso20022.auth030.esma.validation.CommonTradeDataReport69__1TypeFormatValidator;
import iso20022.auth030.esma.validation.CommonTradeDataReport69__1Validator;
import iso20022.auth030.esma.validation.exists.CommonTradeDataReport69__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommonTradeDataReport69__1.class)
public class CommonTradeDataReport69__1Meta implements RosettaMetaData<CommonTradeDataReport69__1> {

	@Override
	public List<Validator<? super CommonTradeDataReport69__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommonTradeDataReport69__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommonTradeDataReport69__1> validator(ValidatorFactory factory) {
		return factory.<CommonTradeDataReport69__1>create(CommonTradeDataReport69__1Validator.class);
	}

	@Override
	public Validator<? super CommonTradeDataReport69__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommonTradeDataReport69__1>create(CommonTradeDataReport69__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommonTradeDataReport69__1> validator() {
		return new CommonTradeDataReport69__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super CommonTradeDataReport69__1> typeFormatValidator() {
		return new CommonTradeDataReport69__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommonTradeDataReport69__1, Set<String>> onlyExistsValidator() {
		return new CommonTradeDataReport69__1OnlyExistsValidator();
	}
}
