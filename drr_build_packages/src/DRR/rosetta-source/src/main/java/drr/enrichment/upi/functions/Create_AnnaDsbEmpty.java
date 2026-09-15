package drr.enrichment.upi.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.standards.iosco.upi.AnnaDsbEmpty;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_AnnaDsbEmpty.Create_AnnaDsbEmptyDefault.class)
public abstract class Create_AnnaDsbEmpty implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @return result 
	*/
	public AnnaDsbEmpty evaluate() {
		AnnaDsbEmpty.AnnaDsbEmptyBuilder resultBuilder = doEvaluate();
		
		final AnnaDsbEmpty result;
		if (resultBuilder == null) {
			result = null;
		} else {
			result = resultBuilder.build();
			objectValidator.validate(AnnaDsbEmpty.class, result);
		}
		
		return result;
	}

	protected abstract AnnaDsbEmpty.AnnaDsbEmptyBuilder doEvaluate();

	public static class Create_AnnaDsbEmptyDefault extends Create_AnnaDsbEmpty {
		@Override
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder doEvaluate() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result = AnnaDsbEmpty.builder();
			return assignOutput(result);
		}
		
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder assignOutput(AnnaDsbEmpty.AnnaDsbEmptyBuilder result) {
			result = toBuilder(AnnaDsbEmpty.builder()
				.setEmptyField("")
				.build());
			
			return Optional.ofNullable(result)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
