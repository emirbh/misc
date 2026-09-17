package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.RoutingIds;
import fpml.consolidated.shared.validation.RoutingIdsTypeFormatValidator;
import fpml.consolidated.shared.validation.RoutingIdsValidator;
import fpml.consolidated.shared.validation.exists.RoutingIdsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RoutingIds.class)
public class RoutingIdsMeta implements RosettaMetaData<RoutingIds> {

	@Override
	public List<Validator<? super RoutingIds>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RoutingIds, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RoutingIds> validator(ValidatorFactory factory) {
		return factory.<RoutingIds>create(RoutingIdsValidator.class);
	}

	@Override
	public Validator<? super RoutingIds> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RoutingIds>create(RoutingIdsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RoutingIds> validator() {
		return new RoutingIdsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RoutingIds> typeFormatValidator() {
		return new RoutingIdsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RoutingIds, Set<String>> onlyExistsValidator() {
		return new RoutingIdsOnlyExistsValidator();
	}
}
