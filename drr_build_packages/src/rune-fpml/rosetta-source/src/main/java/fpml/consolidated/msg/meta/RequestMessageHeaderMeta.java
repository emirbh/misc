package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.msg.validation.RequestMessageHeaderTypeFormatValidator;
import fpml.consolidated.msg.validation.RequestMessageHeaderValidator;
import fpml.consolidated.msg.validation.exists.RequestMessageHeaderOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RequestMessageHeader.class)
public class RequestMessageHeaderMeta implements RosettaMetaData<RequestMessageHeader> {

	@Override
	public List<Validator<? super RequestMessageHeader>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RequestMessageHeader, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RequestMessageHeader> validator(ValidatorFactory factory) {
		return factory.<RequestMessageHeader>create(RequestMessageHeaderValidator.class);
	}

	@Override
	public Validator<? super RequestMessageHeader> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RequestMessageHeader>create(RequestMessageHeaderTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RequestMessageHeader> validator() {
		return new RequestMessageHeaderValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RequestMessageHeader> typeFormatValidator() {
		return new RequestMessageHeaderTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestMessageHeader, Set<String>> onlyExistsValidator() {
		return new RequestMessageHeaderOnlyExistsValidator();
	}
}
