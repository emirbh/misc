package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.RoutingIdsAndExplicitDetails;
import fpml.consolidated.shared.validation.RoutingIdsAndExplicitDetailsTypeFormatValidator;
import fpml.consolidated.shared.validation.RoutingIdsAndExplicitDetailsValidator;
import fpml.consolidated.shared.validation.exists.RoutingIdsAndExplicitDetailsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RoutingIdsAndExplicitDetails.class)
public class RoutingIdsAndExplicitDetailsMeta implements RosettaMetaData<RoutingIdsAndExplicitDetails> {

	@Override
	public List<Validator<? super RoutingIdsAndExplicitDetails>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RoutingIdsAndExplicitDetails, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RoutingIdsAndExplicitDetails> validator(ValidatorFactory factory) {
		return factory.<RoutingIdsAndExplicitDetails>create(RoutingIdsAndExplicitDetailsValidator.class);
	}

	@Override
	public Validator<? super RoutingIdsAndExplicitDetails> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RoutingIdsAndExplicitDetails>create(RoutingIdsAndExplicitDetailsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RoutingIdsAndExplicitDetails> validator() {
		return new RoutingIdsAndExplicitDetailsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RoutingIdsAndExplicitDetails> typeFormatValidator() {
		return new RoutingIdsAndExplicitDetailsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RoutingIdsAndExplicitDetails, Set<String>> onlyExistsValidator() {
		return new RoutingIdsAndExplicitDetailsOnlyExistsValidator();
	}
}
