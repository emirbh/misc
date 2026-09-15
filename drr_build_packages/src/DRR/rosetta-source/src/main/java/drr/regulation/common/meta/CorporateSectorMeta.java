package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.CorporateSector;
import drr.regulation.common.validation.CorporateSectorTypeFormatValidator;
import drr.regulation.common.validation.CorporateSectorValidator;
import drr.regulation.common.validation.exists.CorporateSectorOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=CorporateSector.class)
public class CorporateSectorMeta implements RosettaMetaData<CorporateSector> {

	@Override
	public List<Validator<? super CorporateSector>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CorporateSector, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CorporateSector> validator(ValidatorFactory factory) {
		return factory.<CorporateSector>create(CorporateSectorValidator.class);
	}

	@Override
	public Validator<? super CorporateSector> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CorporateSector>create(CorporateSectorTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CorporateSector> validator() {
		return new CorporateSectorValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CorporateSector> typeFormatValidator() {
		return new CorporateSectorTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CorporateSector, Set<String>> onlyExistsValidator() {
		return new CorporateSectorOnlyExistsValidator();
	}
}
