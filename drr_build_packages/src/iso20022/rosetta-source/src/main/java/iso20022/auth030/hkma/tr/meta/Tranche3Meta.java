package iso20022.auth030.hkma.tr.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.Tranche3;
import iso20022.auth030.hkma.tr.validation.Tranche3TypeFormatValidator;
import iso20022.auth030.hkma.tr.validation.Tranche3Validator;
import iso20022.auth030.hkma.tr.validation.exists.Tranche3OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Tranche3.class)
public class Tranche3Meta implements RosettaMetaData<Tranche3> {

	@Override
	public List<Validator<? super Tranche3>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Tranche3, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Tranche3> validator(ValidatorFactory factory) {
		return factory.<Tranche3>create(Tranche3Validator.class);
	}

	@Override
	public Validator<? super Tranche3> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Tranche3>create(Tranche3TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Tranche3> validator() {
		return new Tranche3Validator();
	}

	@Deprecated
	@Override
	public Validator<? super Tranche3> typeFormatValidator() {
		return new Tranche3TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Tranche3, Set<String>> onlyExistsValidator() {
		return new Tranche3OnlyExistsValidator();
	}
}
