package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.Region;
import fpml.consolidated.shared.validation.RegionTypeFormatValidator;
import fpml.consolidated.shared.validation.RegionValidator;
import fpml.consolidated.shared.validation.exists.RegionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Region.class)
public class RegionMeta implements RosettaMetaData<Region> {

	@Override
	public List<Validator<? super Region>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Region, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Region> validator(ValidatorFactory factory) {
		return factory.<Region>create(RegionValidator.class);
	}

	@Override
	public Validator<? super Region> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Region>create(RegionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Region> validator() {
		return new RegionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Region> typeFormatValidator() {
		return new RegionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Region, Set<String>> onlyExistsValidator() {
		return new RegionOnlyExistsValidator();
	}
}
