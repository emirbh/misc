package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.AveragePriceLeg;
import fpml.consolidated.com.validation.AveragePriceLegTypeFormatValidator;
import fpml.consolidated.com.validation.AveragePriceLegValidator;
import fpml.consolidated.com.validation.datarule.AveragePriceLegChoice0;
import fpml.consolidated.com.validation.datarule.AveragePriceLegChoice1;
import fpml.consolidated.com.validation.exists.AveragePriceLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AveragePriceLeg.class)
public class AveragePriceLegMeta implements RosettaMetaData<AveragePriceLeg> {

	@Override
	public List<Validator<? super AveragePriceLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AveragePriceLeg>create(AveragePriceLegChoice0.class),
			factory.<AveragePriceLeg>create(AveragePriceLegChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super AveragePriceLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AveragePriceLeg> validator(ValidatorFactory factory) {
		return factory.<AveragePriceLeg>create(AveragePriceLegValidator.class);
	}

	@Override
	public Validator<? super AveragePriceLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AveragePriceLeg>create(AveragePriceLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AveragePriceLeg> validator() {
		return new AveragePriceLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AveragePriceLeg> typeFormatValidator() {
		return new AveragePriceLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AveragePriceLeg, Set<String>> onlyExistsValidator() {
		return new AveragePriceLegOnlyExistsValidator();
	}
}
