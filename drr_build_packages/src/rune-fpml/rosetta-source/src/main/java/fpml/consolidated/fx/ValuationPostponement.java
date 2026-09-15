package fpml.consolidated.fx;

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
import fpml.consolidated.fx.meta.ValuationPostponementMeta;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Indicates that the Valuation Date for the tranaction shall be deemed to be the first Business Day following the day on which the applicable Disruption Event ceases to exist, unless the events continues to exists for more than a maximum number of days.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Indicates that the Valuation Date for the tranaction shall be deemed to be the first Business Day following the day on which the applicable Disruption Event ceases to exist, unless the events continues to exists for more than a maximum number of days.
 *
 */
@RosettaDataType(value="ValuationPostponement", builder=ValuationPostponement.ValuationPostponementBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ValuationPostponement", model="fpml", builder=ValuationPostponement.ValuationPostponementBuilderImpl.class, version="2.1.1")
public interface ValuationPostponement extends Postponement {

	ValuationPostponementMeta metaData = new ValuationPostponementMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	ValuationPostponement build();
	
	ValuationPostponement.ValuationPostponementBuilder toBuilder();
	
	static ValuationPostponement.ValuationPostponementBuilder builder() {
		return new ValuationPostponement.ValuationPostponementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ValuationPostponement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ValuationPostponement> getType() {
		return ValuationPostponement.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("maximumNumberOfDays"), Integer.class, getMaximumNumberOfDays(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ValuationPostponementBuilder extends ValuationPostponement, Postponement.PostponementBuilder {
		@Override
		ValuationPostponement.ValuationPostponementBuilder setMaximumNumberOfDays(Integer maximumNumberOfDays);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("maximumNumberOfDays"), Integer.class, getMaximumNumberOfDays(), this);
		}
		

		ValuationPostponement.ValuationPostponementBuilder prune();
	}

	/*********************** Immutable Implementation of ValuationPostponement  ***********************/
	class ValuationPostponementImpl extends Postponement.PostponementImpl implements ValuationPostponement {
		
		protected ValuationPostponementImpl(ValuationPostponement.ValuationPostponementBuilder builder) {
			super(builder);
		}
		
		@Override
		public ValuationPostponement build() {
			return this;
		}
		
		@Override
		public ValuationPostponement.ValuationPostponementBuilder toBuilder() {
			ValuationPostponement.ValuationPostponementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ValuationPostponement.ValuationPostponementBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationPostponement {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ValuationPostponement  ***********************/
	class ValuationPostponementBuilderImpl extends Postponement.PostponementBuilderImpl implements ValuationPostponement.ValuationPostponementBuilder {
	
		
		@RosettaAttribute("maximumNumberOfDays")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maximumNumberOfDays")
		@Override
		public ValuationPostponement.ValuationPostponementBuilder setMaximumNumberOfDays(Integer _maximumNumberOfDays) {
			this.maximumNumberOfDays = _maximumNumberOfDays == null ? null : _maximumNumberOfDays;
			return this;
		}
		
		@Override
		public ValuationPostponement build() {
			return new ValuationPostponement.ValuationPostponementImpl(this);
		}
		
		@Override
		public ValuationPostponement.ValuationPostponementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationPostponement.ValuationPostponementBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationPostponement.ValuationPostponementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ValuationPostponement.ValuationPostponementBuilder o = (ValuationPostponement.ValuationPostponementBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationPostponementBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
