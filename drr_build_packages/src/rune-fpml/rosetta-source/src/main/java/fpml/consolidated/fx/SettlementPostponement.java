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
import fpml.consolidated.fx.meta.SettlementPostponementMeta;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Indicates that the Settlement Date for the tranaction shall be deemed to be the first Business Day following the day on which the applicable Disruption Event ceases to exist, unless the events continues to exists for more than a maximum number of days.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Indicates that the Settlement Date for the tranaction shall be deemed to be the first Business Day following the day on which the applicable Disruption Event ceases to exist, unless the events continues to exists for more than a maximum number of days.
 *
 */
@RosettaDataType(value="SettlementPostponement", builder=SettlementPostponement.SettlementPostponementBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SettlementPostponement", model="fpml", builder=SettlementPostponement.SettlementPostponementBuilderImpl.class, version="2.1.1")
public interface SettlementPostponement extends Postponement {

	SettlementPostponementMeta metaData = new SettlementPostponementMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	SettlementPostponement build();
	
	SettlementPostponement.SettlementPostponementBuilder toBuilder();
	
	static SettlementPostponement.SettlementPostponementBuilder builder() {
		return new SettlementPostponement.SettlementPostponementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementPostponement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SettlementPostponement> getType() {
		return SettlementPostponement.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("maximumNumberOfDays"), Integer.class, getMaximumNumberOfDays(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementPostponementBuilder extends SettlementPostponement, Postponement.PostponementBuilder {
		@Override
		SettlementPostponement.SettlementPostponementBuilder setMaximumNumberOfDays(Integer maximumNumberOfDays);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("maximumNumberOfDays"), Integer.class, getMaximumNumberOfDays(), this);
		}
		

		SettlementPostponement.SettlementPostponementBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementPostponement  ***********************/
	class SettlementPostponementImpl extends Postponement.PostponementImpl implements SettlementPostponement {
		
		protected SettlementPostponementImpl(SettlementPostponement.SettlementPostponementBuilder builder) {
			super(builder);
		}
		
		@Override
		public SettlementPostponement build() {
			return this;
		}
		
		@Override
		public SettlementPostponement.SettlementPostponementBuilder toBuilder() {
			SettlementPostponement.SettlementPostponementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementPostponement.SettlementPostponementBuilder builder) {
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
			return "SettlementPostponement {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SettlementPostponement  ***********************/
	class SettlementPostponementBuilderImpl extends Postponement.PostponementBuilderImpl implements SettlementPostponement.SettlementPostponementBuilder {
	
		
		@RosettaAttribute("maximumNumberOfDays")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maximumNumberOfDays")
		@Override
		public SettlementPostponement.SettlementPostponementBuilder setMaximumNumberOfDays(Integer _maximumNumberOfDays) {
			this.maximumNumberOfDays = _maximumNumberOfDays == null ? null : _maximumNumberOfDays;
			return this;
		}
		
		@Override
		public SettlementPostponement build() {
			return new SettlementPostponement.SettlementPostponementImpl(this);
		}
		
		@Override
		public SettlementPostponement.SettlementPostponementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPostponement.SettlementPostponementBuilder prune() {
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
		public SettlementPostponement.SettlementPostponementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			SettlementPostponement.SettlementPostponementBuilder o = (SettlementPostponement.SettlementPostponementBuilder) other;
			
			
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
			return "SettlementPostponementBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
