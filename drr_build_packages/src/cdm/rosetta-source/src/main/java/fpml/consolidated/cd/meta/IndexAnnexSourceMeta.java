package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.IndexAnnexSource;
import fpml.consolidated.cd.validation.IndexAnnexSourceTypeFormatValidator;
import fpml.consolidated.cd.validation.IndexAnnexSourceValidator;
import fpml.consolidated.cd.validation.exists.IndexAnnexSourceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=IndexAnnexSource.class)
public class IndexAnnexSourceMeta implements RosettaMetaData<IndexAnnexSource> {

	@Override
	public List<Validator<? super IndexAnnexSource>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IndexAnnexSource, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super IndexAnnexSource> validator(ValidatorFactory factory) {
		return factory.<IndexAnnexSource>create(IndexAnnexSourceValidator.class);
	}

	@Override
	public Validator<? super IndexAnnexSource> typeFormatValidator(ValidatorFactory factory) {
		return factory.<IndexAnnexSource>create(IndexAnnexSourceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super IndexAnnexSource> validator() {
		return new IndexAnnexSourceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super IndexAnnexSource> typeFormatValidator() {
		return new IndexAnnexSourceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IndexAnnexSource, Set<String>> onlyExistsValidator() {
		return new IndexAnnexSourceOnlyExistsValidator();
	}
}
