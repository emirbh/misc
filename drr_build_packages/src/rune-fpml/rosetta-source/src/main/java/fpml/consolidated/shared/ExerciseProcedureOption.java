package fpml.consolidated.shared;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.shared.meta.ExerciseProcedureOptionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type describing how notice of exercise should be given. This can be either manual or automatic.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing how notice of exercise should be given. This can be either manual or automatic.
 *
 */
@RosettaDataType(value="ExerciseProcedureOption", builder=ExerciseProcedureOption.ExerciseProcedureOptionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ExerciseProcedureOption", model="fpml", builder=ExerciseProcedureOption.ExerciseProcedureOptionBuilderImpl.class, version="2.1.1")
public interface ExerciseProcedureOption extends RosettaModelObject {

	ExerciseProcedureOptionMeta metaData = new ExerciseProcedureOptionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies that the notice of exercise must be given by the buyer to the seller or seller's agent.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies that the notice of exercise must be given by the buyer to the seller or seller's agent.
	 *
	 */
	Empty getManualExercise();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If automatic is specified then the notional amount of the underlying swap, not previously exercised under the swaption will be automatically exercised at the expriration time on the expiration date if at such time the buyer is in-the-money, provided that the difference between the settlement rate and the fixed rate under the relevant underlying swap is not less than the specified threshold rate. The term in-the-money is assumed to have the meaning defining in the 2000 ISDA Definitions, Section 17.4 In-the-money.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If automatic is specified then the notional amount of the underlying swap, not previously exercised under the swaption will be automatically exercised at the expriration time on the expiration date if at such time the buyer is in-the-money, provided that the difference between the settlement rate and the fixed rate under the relevant underlying swap is not less than the specified threshold rate. The term in-the-money is assumed to have the meaning defining in the 2000 ISDA Definitions, Section 17.4 In-the-money.
	 *
	 */
	Empty getAutomaticExercise();

	/*********************** Build Methods  ***********************/
	ExerciseProcedureOption build();
	
	ExerciseProcedureOption.ExerciseProcedureOptionBuilder toBuilder();
	
	static ExerciseProcedureOption.ExerciseProcedureOptionBuilder builder() {
		return new ExerciseProcedureOption.ExerciseProcedureOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExerciseProcedureOption> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ExerciseProcedureOption> getType() {
		return ExerciseProcedureOption.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("manualExercise"), processor, Empty.class, getManualExercise());
		processRosetta(path.newSubPath("automaticExercise"), processor, Empty.class, getAutomaticExercise());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExerciseProcedureOptionBuilder extends ExerciseProcedureOption, RosettaModelObjectBuilder {
		Empty.EmptyBuilder getOrCreateManualExercise();
		@Override
		Empty.EmptyBuilder getManualExercise();
		Empty.EmptyBuilder getOrCreateAutomaticExercise();
		@Override
		Empty.EmptyBuilder getAutomaticExercise();
		ExerciseProcedureOption.ExerciseProcedureOptionBuilder setManualExercise(Empty manualExercise);
		ExerciseProcedureOption.ExerciseProcedureOptionBuilder setAutomaticExercise(Empty automaticExercise);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("manualExercise"), processor, Empty.EmptyBuilder.class, getManualExercise());
			processRosetta(path.newSubPath("automaticExercise"), processor, Empty.EmptyBuilder.class, getAutomaticExercise());
		}
		

		ExerciseProcedureOption.ExerciseProcedureOptionBuilder prune();
	}

	/*********************** Immutable Implementation of ExerciseProcedureOption  ***********************/
	class ExerciseProcedureOptionImpl implements ExerciseProcedureOption {
		private final Empty manualExercise;
		private final Empty automaticExercise;
		
		protected ExerciseProcedureOptionImpl(ExerciseProcedureOption.ExerciseProcedureOptionBuilder builder) {
			this.manualExercise = ofNullable(builder.getManualExercise()).map(f->f.build()).orElse(null);
			this.automaticExercise = ofNullable(builder.getAutomaticExercise()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("manualExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("manualExercise")
		public Empty getManualExercise() {
			return manualExercise;
		}
		
		@Override
		@RosettaAttribute("automaticExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("automaticExercise")
		public Empty getAutomaticExercise() {
			return automaticExercise;
		}
		
		@Override
		public ExerciseProcedureOption build() {
			return this;
		}
		
		@Override
		public ExerciseProcedureOption.ExerciseProcedureOptionBuilder toBuilder() {
			ExerciseProcedureOption.ExerciseProcedureOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExerciseProcedureOption.ExerciseProcedureOptionBuilder builder) {
			ofNullable(getManualExercise()).ifPresent(builder::setManualExercise);
			ofNullable(getAutomaticExercise()).ifPresent(builder::setAutomaticExercise);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExerciseProcedureOption _that = getType().cast(o);
		
			if (!Objects.equals(manualExercise, _that.getManualExercise())) return false;
			if (!Objects.equals(automaticExercise, _that.getAutomaticExercise())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (manualExercise != null ? manualExercise.hashCode() : 0);
			_result = 31 * _result + (automaticExercise != null ? automaticExercise.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseProcedureOption {" +
				"manualExercise=" + this.manualExercise + ", " +
				"automaticExercise=" + this.automaticExercise +
			'}';
		}
	}

	/*********************** Builder Implementation of ExerciseProcedureOption  ***********************/
	class ExerciseProcedureOptionBuilderImpl implements ExerciseProcedureOption.ExerciseProcedureOptionBuilder {
	
		protected Empty.EmptyBuilder manualExercise;
		protected Empty.EmptyBuilder automaticExercise;
		
		@Override
		@RosettaAttribute("manualExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("manualExercise")
		public Empty.EmptyBuilder getManualExercise() {
			return manualExercise;
		}
		
		@Override
		public Empty.EmptyBuilder getOrCreateManualExercise() {
			Empty.EmptyBuilder result;
			if (manualExercise!=null) {
				result = manualExercise;
			}
			else {
				result = manualExercise = Empty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("automaticExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("automaticExercise")
		public Empty.EmptyBuilder getAutomaticExercise() {
			return automaticExercise;
		}
		
		@Override
		public Empty.EmptyBuilder getOrCreateAutomaticExercise() {
			Empty.EmptyBuilder result;
			if (automaticExercise!=null) {
				result = automaticExercise;
			}
			else {
				result = automaticExercise = Empty.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("manualExercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("manualExercise")
		@Override
		public ExerciseProcedureOption.ExerciseProcedureOptionBuilder setManualExercise(Empty _manualExercise) {
			this.manualExercise = _manualExercise == null ? null : _manualExercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("automaticExercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("automaticExercise")
		@Override
		public ExerciseProcedureOption.ExerciseProcedureOptionBuilder setAutomaticExercise(Empty _automaticExercise) {
			this.automaticExercise = _automaticExercise == null ? null : _automaticExercise.toBuilder();
			return this;
		}
		
		@Override
		public ExerciseProcedureOption build() {
			return new ExerciseProcedureOption.ExerciseProcedureOptionImpl(this);
		}
		
		@Override
		public ExerciseProcedureOption.ExerciseProcedureOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseProcedureOption.ExerciseProcedureOptionBuilder prune() {
			if (manualExercise!=null && !manualExercise.prune().hasData()) manualExercise = null;
			if (automaticExercise!=null && !automaticExercise.prune().hasData()) automaticExercise = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getManualExercise()!=null && getManualExercise().hasData()) return true;
			if (getAutomaticExercise()!=null && getAutomaticExercise().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseProcedureOption.ExerciseProcedureOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExerciseProcedureOption.ExerciseProcedureOptionBuilder o = (ExerciseProcedureOption.ExerciseProcedureOptionBuilder) other;
			
			merger.mergeRosetta(getManualExercise(), o.getManualExercise(), this::setManualExercise);
			merger.mergeRosetta(getAutomaticExercise(), o.getAutomaticExercise(), this::setAutomaticExercise);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExerciseProcedureOption _that = getType().cast(o);
		
			if (!Objects.equals(manualExercise, _that.getManualExercise())) return false;
			if (!Objects.equals(automaticExercise, _that.getAutomaticExercise())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (manualExercise != null ? manualExercise.hashCode() : 0);
			_result = 31 * _result + (automaticExercise != null ? automaticExercise.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseProcedureOptionBuilder {" +
				"manualExercise=" + this.manualExercise + ", " +
				"automaticExercise=" + this.automaticExercise +
			'}';
		}
	}
}
