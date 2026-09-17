package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.RoutingId;
import fpml.consolidated.shared.validation.RoutingIdTypeFormatValidator;
import fpml.consolidated.shared.validation.RoutingIdValidator;
import fpml.consolidated.shared.validation.exists.RoutingIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RoutingId.class)
public class RoutingIdMeta implements RosettaMetaData<RoutingId> {

	@Override
	public List<Validator<? super RoutingId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RoutingId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RoutingId> validator(ValidatorFactory factory) {
		return factory.<RoutingId>create(RoutingIdValidator.class);
	}

	@Override
	public Validator<? super RoutingId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RoutingId>create(RoutingIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RoutingId> validator() {
		return new RoutingIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RoutingId> typeFormatValidator() {
		return new RoutingIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RoutingId, Set<String>> onlyExistsValidator() {
		return new RoutingIdOnlyExistsValidator();
	}
}
