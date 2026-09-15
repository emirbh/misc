package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.CommodityMultipleExerciseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type for defining the multiple exercise provisions of an American style commodity option.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type for defining the multiple exercise provisions of an American style commodity option.
 *
 */
@RosettaDataType(value="CommodityMultipleExercise", builder=CommodityMultipleExercise.CommodityMultipleExerciseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityMultipleExercise", model="fpml", builder=CommodityMultipleExercise.CommodityMultipleExerciseBuilderImpl.class, version="2.1.1")
public interface CommodityMultipleExercise extends RosettaModelObject {

	CommodityMultipleExerciseMeta metaData = new CommodityMultipleExerciseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The integral multiple quantity defines a lower limit of the Notional Quantity that can be exercised and also defines a unit multiple of the Notional Quantity that can be exercised, i.e. only integer multiples of this Notional Quantity can be exercised.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The integral multiple quantity defines a lower limit of the Notional Quantity that can be exercised and also defines a unit multiple of the Notional Quantity that can be exercised, i.e. only integer multiples of this Notional Quantity can be exercised.
	 *
	 */
	CommodityNotionalQuantity getIntegralMultipleQuantity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The minimum Notional Quantity that can be exercised on a given Exercise Date. See multipleExercise.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The minimum Notional Quantity that can be exercised on a given Exercise Date. See multipleExercise.
	 *
	 */
	CommodityNotionalQuantity getMinimumNotionalQuantity();

	/*********************** Build Methods  ***********************/
	CommodityMultipleExercise build();
	
	CommodityMultipleExercise.CommodityMultipleExerciseBuilder toBuilder();
	
	static CommodityMultipleExercise.CommodityMultipleExerciseBuilder builder() {
		return new CommodityMultipleExercise.CommodityMultipleExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityMultipleExercise> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityMultipleExercise> getType() {
		return CommodityMultipleExercise.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("integralMultipleQuantity"), processor, CommodityNotionalQuantity.class, getIntegralMultipleQuantity());
		processRosetta(path.newSubPath("minimumNotionalQuantity"), processor, CommodityNotionalQuantity.class, getMinimumNotionalQuantity());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityMultipleExerciseBuilder extends CommodityMultipleExercise, RosettaModelObjectBuilder {
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateIntegralMultipleQuantity();
		@Override
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getIntegralMultipleQuantity();
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateMinimumNotionalQuantity();
		@Override
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getMinimumNotionalQuantity();
		CommodityMultipleExercise.CommodityMultipleExerciseBuilder setIntegralMultipleQuantity(CommodityNotionalQuantity integralMultipleQuantity);
		CommodityMultipleExercise.CommodityMultipleExerciseBuilder setMinimumNotionalQuantity(CommodityNotionalQuantity minimumNotionalQuantity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("integralMultipleQuantity"), processor, CommodityNotionalQuantity.CommodityNotionalQuantityBuilder.class, getIntegralMultipleQuantity());
			processRosetta(path.newSubPath("minimumNotionalQuantity"), processor, CommodityNotionalQuantity.CommodityNotionalQuantityBuilder.class, getMinimumNotionalQuantity());
		}
		

		CommodityMultipleExercise.CommodityMultipleExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityMultipleExercise  ***********************/
	class CommodityMultipleExerciseImpl implements CommodityMultipleExercise {
		private final CommodityNotionalQuantity integralMultipleQuantity;
		private final CommodityNotionalQuantity minimumNotionalQuantity;
		
		protected CommodityMultipleExerciseImpl(CommodityMultipleExercise.CommodityMultipleExerciseBuilder builder) {
			this.integralMultipleQuantity = ofNullable(builder.getIntegralMultipleQuantity()).map(f->f.build()).orElse(null);
			this.minimumNotionalQuantity = ofNullable(builder.getMinimumNotionalQuantity()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("integralMultipleQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("integralMultipleQuantity")
		public CommodityNotionalQuantity getIntegralMultipleQuantity() {
			return integralMultipleQuantity;
		}
		
		@Override
		@RosettaAttribute("minimumNotionalQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumNotionalQuantity")
		public CommodityNotionalQuantity getMinimumNotionalQuantity() {
			return minimumNotionalQuantity;
		}
		
		@Override
		public CommodityMultipleExercise build() {
			return this;
		}
		
		@Override
		public CommodityMultipleExercise.CommodityMultipleExerciseBuilder toBuilder() {
			CommodityMultipleExercise.CommodityMultipleExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityMultipleExercise.CommodityMultipleExerciseBuilder builder) {
			ofNullable(getIntegralMultipleQuantity()).ifPresent(builder::setIntegralMultipleQuantity);
			ofNullable(getMinimumNotionalQuantity()).ifPresent(builder::setMinimumNotionalQuantity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityMultipleExercise _that = getType().cast(o);
		
			if (!Objects.equals(integralMultipleQuantity, _that.getIntegralMultipleQuantity())) return false;
			if (!Objects.equals(minimumNotionalQuantity, _that.getMinimumNotionalQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (integralMultipleQuantity != null ? integralMultipleQuantity.hashCode() : 0);
			_result = 31 * _result + (minimumNotionalQuantity != null ? minimumNotionalQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityMultipleExercise {" +
				"integralMultipleQuantity=" + this.integralMultipleQuantity + ", " +
				"minimumNotionalQuantity=" + this.minimumNotionalQuantity +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityMultipleExercise  ***********************/
	class CommodityMultipleExerciseBuilderImpl implements CommodityMultipleExercise.CommodityMultipleExerciseBuilder {
	
		protected CommodityNotionalQuantity.CommodityNotionalQuantityBuilder integralMultipleQuantity;
		protected CommodityNotionalQuantity.CommodityNotionalQuantityBuilder minimumNotionalQuantity;
		
		@Override
		@RosettaAttribute("integralMultipleQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("integralMultipleQuantity")
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getIntegralMultipleQuantity() {
			return integralMultipleQuantity;
		}
		
		@Override
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateIntegralMultipleQuantity() {
			CommodityNotionalQuantity.CommodityNotionalQuantityBuilder result;
			if (integralMultipleQuantity!=null) {
				result = integralMultipleQuantity;
			}
			else {
				result = integralMultipleQuantity = CommodityNotionalQuantity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("minimumNotionalQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumNotionalQuantity")
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getMinimumNotionalQuantity() {
			return minimumNotionalQuantity;
		}
		
		@Override
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateMinimumNotionalQuantity() {
			CommodityNotionalQuantity.CommodityNotionalQuantityBuilder result;
			if (minimumNotionalQuantity!=null) {
				result = minimumNotionalQuantity;
			}
			else {
				result = minimumNotionalQuantity = CommodityNotionalQuantity.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("integralMultipleQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("integralMultipleQuantity")
		@Override
		public CommodityMultipleExercise.CommodityMultipleExerciseBuilder setIntegralMultipleQuantity(CommodityNotionalQuantity _integralMultipleQuantity) {
			this.integralMultipleQuantity = _integralMultipleQuantity == null ? null : _integralMultipleQuantity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("minimumNotionalQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("minimumNotionalQuantity")
		@Override
		public CommodityMultipleExercise.CommodityMultipleExerciseBuilder setMinimumNotionalQuantity(CommodityNotionalQuantity _minimumNotionalQuantity) {
			this.minimumNotionalQuantity = _minimumNotionalQuantity == null ? null : _minimumNotionalQuantity.toBuilder();
			return this;
		}
		
		@Override
		public CommodityMultipleExercise build() {
			return new CommodityMultipleExercise.CommodityMultipleExerciseImpl(this);
		}
		
		@Override
		public CommodityMultipleExercise.CommodityMultipleExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityMultipleExercise.CommodityMultipleExerciseBuilder prune() {
			if (integralMultipleQuantity!=null && !integralMultipleQuantity.prune().hasData()) integralMultipleQuantity = null;
			if (minimumNotionalQuantity!=null && !minimumNotionalQuantity.prune().hasData()) minimumNotionalQuantity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIntegralMultipleQuantity()!=null && getIntegralMultipleQuantity().hasData()) return true;
			if (getMinimumNotionalQuantity()!=null && getMinimumNotionalQuantity().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityMultipleExercise.CommodityMultipleExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityMultipleExercise.CommodityMultipleExerciseBuilder o = (CommodityMultipleExercise.CommodityMultipleExerciseBuilder) other;
			
			merger.mergeRosetta(getIntegralMultipleQuantity(), o.getIntegralMultipleQuantity(), this::setIntegralMultipleQuantity);
			merger.mergeRosetta(getMinimumNotionalQuantity(), o.getMinimumNotionalQuantity(), this::setMinimumNotionalQuantity);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityMultipleExercise _that = getType().cast(o);
		
			if (!Objects.equals(integralMultipleQuantity, _that.getIntegralMultipleQuantity())) return false;
			if (!Objects.equals(minimumNotionalQuantity, _that.getMinimumNotionalQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (integralMultipleQuantity != null ? integralMultipleQuantity.hashCode() : 0);
			_result = 31 * _result + (minimumNotionalQuantity != null ? minimumNotionalQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityMultipleExerciseBuilder {" +
				"integralMultipleQuantity=" + this.integralMultipleQuantity + ", " +
				"minimumNotionalQuantity=" + this.minimumNotionalQuantity +
			'}';
		}
	}
}
