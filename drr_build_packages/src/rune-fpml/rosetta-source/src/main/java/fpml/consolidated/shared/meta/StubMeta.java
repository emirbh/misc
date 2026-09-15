package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.Stub;
import fpml.consolidated.shared.StubValue;
import fpml.consolidated.shared.validation.StubTypeFormatValidator;
import fpml.consolidated.shared.validation.StubValidator;
import fpml.consolidated.shared.validation.datarule.StubValueChoice;
import fpml.consolidated.shared.validation.exists.StubOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Stub.class)
public class StubMeta implements RosettaMetaData<Stub> {

	@Override
	public List<Validator<? super Stub>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<StubValue>create(StubValueChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Stub, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Stub> validator(ValidatorFactory factory) {
		return factory.<Stub>create(StubValidator.class);
	}

	@Override
	public Validator<? super Stub> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Stub>create(StubTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Stub> validator() {
		return new StubValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Stub> typeFormatValidator() {
		return new StubTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Stub, Set<String>> onlyExistsValidator() {
		return new StubOnlyExistsValidator();
	}
}
