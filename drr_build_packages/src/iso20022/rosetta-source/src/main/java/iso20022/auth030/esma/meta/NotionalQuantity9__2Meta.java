package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.NotionalQuantity9__2;
import iso20022.auth030.esma.validation.NotionalQuantity9__2TypeFormatValidator;
import iso20022.auth030.esma.validation.NotionalQuantity9__2Validator;
import iso20022.auth030.esma.validation.exists.NotionalQuantity9__2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=NotionalQuantity9__2.class)
public class NotionalQuantity9__2Meta implements RosettaMetaData<NotionalQuantity9__2> {

	@Override
	public List<Validator<? super NotionalQuantity9__2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NotionalQuantity9__2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NotionalQuantity9__2> validator(ValidatorFactory factory) {
		return factory.<NotionalQuantity9__2>create(NotionalQuantity9__2Validator.class);
	}

	@Override
	public Validator<? super NotionalQuantity9__2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NotionalQuantity9__2>create(NotionalQuantity9__2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NotionalQuantity9__2> validator() {
		return new NotionalQuantity9__2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super NotionalQuantity9__2> typeFormatValidator() {
		return new NotionalQuantity9__2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NotionalQuantity9__2, Set<String>> onlyExistsValidator() {
		return new NotionalQuantity9__2OnlyExistsValidator();
	}
}
