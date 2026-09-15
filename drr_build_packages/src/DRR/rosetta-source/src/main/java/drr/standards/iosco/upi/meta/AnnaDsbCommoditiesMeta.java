package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbCommodities;
import drr.standards.iosco.upi.validation.AnnaDsbCommoditiesTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbCommoditiesValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbCommoditiesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbCommodities.class)
public class AnnaDsbCommoditiesMeta implements RosettaMetaData<AnnaDsbCommodities> {

	@Override
	public List<Validator<? super AnnaDsbCommodities>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbCommodities, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbCommodities> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbCommodities>create(AnnaDsbCommoditiesValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbCommodities> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbCommodities>create(AnnaDsbCommoditiesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbCommodities> validator() {
		return new AnnaDsbCommoditiesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbCommodities> typeFormatValidator() {
		return new AnnaDsbCommoditiesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbCommodities, Set<String>> onlyExistsValidator() {
		return new AnnaDsbCommoditiesOnlyExistsValidator();
	}
}
