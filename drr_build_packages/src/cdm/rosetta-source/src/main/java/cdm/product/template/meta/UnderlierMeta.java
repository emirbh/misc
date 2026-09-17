package cdm.product.template.meta;

import cdm.product.template.Underlier;
import cdm.product.template.validation.UnderlierTypeFormatValidator;
import cdm.product.template.validation.UnderlierValidator;
import cdm.product.template.validation.datarule.UnderlierChoice;
import cdm.product.template.validation.exists.UnderlierOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=Underlier.class)
public class UnderlierMeta implements RosettaMetaData<Underlier> {

	@Override
	public List<Validator<? super Underlier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Underlier>create(UnderlierChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Underlier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Underlier> validator(ValidatorFactory factory) {
		return factory.<Underlier>create(UnderlierValidator.class);
	}

	@Override
	public Validator<? super Underlier> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Underlier>create(UnderlierTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Underlier> validator() {
		return new UnderlierValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Underlier> typeFormatValidator() {
		return new UnderlierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Underlier, Set<String>> onlyExistsValidator() {
		return new UnderlierOnlyExistsValidator();
	}
}
