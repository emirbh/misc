package iso20022.auth030.jfsa.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.TrancheIndicator3Choice__1;
import iso20022.auth030.jfsa.validation.TrancheIndicator3Choice__1TypeFormatValidator;
import iso20022.auth030.jfsa.validation.TrancheIndicator3Choice__1Validator;
import iso20022.auth030.jfsa.validation.exists.TrancheIndicator3Choice__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TrancheIndicator3Choice__1.class)
public class TrancheIndicator3Choice__1Meta implements RosettaMetaData<TrancheIndicator3Choice__1> {

	@Override
	public List<Validator<? super TrancheIndicator3Choice__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TrancheIndicator3Choice__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TrancheIndicator3Choice__1> validator(ValidatorFactory factory) {
		return factory.<TrancheIndicator3Choice__1>create(TrancheIndicator3Choice__1Validator.class);
	}

	@Override
	public Validator<? super TrancheIndicator3Choice__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TrancheIndicator3Choice__1>create(TrancheIndicator3Choice__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TrancheIndicator3Choice__1> validator() {
		return new TrancheIndicator3Choice__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TrancheIndicator3Choice__1> typeFormatValidator() {
		return new TrancheIndicator3Choice__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TrancheIndicator3Choice__1, Set<String>> onlyExistsValidator() {
		return new TrancheIndicator3Choice__1OnlyExistsValidator();
	}
}
