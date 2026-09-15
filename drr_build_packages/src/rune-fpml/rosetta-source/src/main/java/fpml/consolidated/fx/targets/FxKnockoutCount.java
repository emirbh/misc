package fpml.consolidated.fx.targets;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.fx.targets.meta.FxKnockoutCountMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="FxKnockoutCount", builder=FxKnockoutCount.FxKnockoutCountBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxKnockoutCount", model="fpml", builder=FxKnockoutCount.FxKnockoutCountBuilderImpl.class, version="2.1.1")
public interface FxKnockoutCount extends RosettaModelObject {

	FxKnockoutCountMeta metaData = new FxKnockoutCountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Number of fixings that are in the money. No accumulation process.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Number of fixings that are in the money. No accumulation process.
	 *
	 */
	Integer getConditionalFixings();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Whether there is settlement at knockout.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Whether there is settlement at knockout.
	 *
	 */
	Boolean getSettlementAtKnockout();

	/*********************** Build Methods  ***********************/
	FxKnockoutCount build();
	
	FxKnockoutCount.FxKnockoutCountBuilder toBuilder();
	
	static FxKnockoutCount.FxKnockoutCountBuilder builder() {
		return new FxKnockoutCount.FxKnockoutCountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxKnockoutCount> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxKnockoutCount> getType() {
		return FxKnockoutCount.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("conditionalFixings"), Integer.class, getConditionalFixings(), this);
		processor.processBasic(path.newSubPath("settlementAtKnockout"), Boolean.class, getSettlementAtKnockout(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxKnockoutCountBuilder extends FxKnockoutCount, RosettaModelObjectBuilder {
		FxKnockoutCount.FxKnockoutCountBuilder setConditionalFixings(Integer conditionalFixings);
		FxKnockoutCount.FxKnockoutCountBuilder setSettlementAtKnockout(Boolean settlementAtKnockout);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("conditionalFixings"), Integer.class, getConditionalFixings(), this);
			processor.processBasic(path.newSubPath("settlementAtKnockout"), Boolean.class, getSettlementAtKnockout(), this);
		}
		

		FxKnockoutCount.FxKnockoutCountBuilder prune();
	}

	/*********************** Immutable Implementation of FxKnockoutCount  ***********************/
	class FxKnockoutCountImpl implements FxKnockoutCount {
		private final Integer conditionalFixings;
		private final Boolean settlementAtKnockout;
		
		protected FxKnockoutCountImpl(FxKnockoutCount.FxKnockoutCountBuilder builder) {
			this.conditionalFixings = builder.getConditionalFixings();
			this.settlementAtKnockout = builder.getSettlementAtKnockout();
		}
		
		@Override
		@RosettaAttribute("conditionalFixings")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("conditionalFixings")
		public Integer getConditionalFixings() {
			return conditionalFixings;
		}
		
		@Override
		@RosettaAttribute("settlementAtKnockout")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("settlementAtKnockout")
		public Boolean getSettlementAtKnockout() {
			return settlementAtKnockout;
		}
		
		@Override
		public FxKnockoutCount build() {
			return this;
		}
		
		@Override
		public FxKnockoutCount.FxKnockoutCountBuilder toBuilder() {
			FxKnockoutCount.FxKnockoutCountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxKnockoutCount.FxKnockoutCountBuilder builder) {
			ofNullable(getConditionalFixings()).ifPresent(builder::setConditionalFixings);
			ofNullable(getSettlementAtKnockout()).ifPresent(builder::setSettlementAtKnockout);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxKnockoutCount _that = getType().cast(o);
		
			if (!Objects.equals(conditionalFixings, _that.getConditionalFixings())) return false;
			if (!Objects.equals(settlementAtKnockout, _that.getSettlementAtKnockout())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (conditionalFixings != null ? conditionalFixings.hashCode() : 0);
			_result = 31 * _result + (settlementAtKnockout != null ? settlementAtKnockout.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxKnockoutCount {" +
				"conditionalFixings=" + this.conditionalFixings + ", " +
				"settlementAtKnockout=" + this.settlementAtKnockout +
			'}';
		}
	}

	/*********************** Builder Implementation of FxKnockoutCount  ***********************/
	class FxKnockoutCountBuilderImpl implements FxKnockoutCount.FxKnockoutCountBuilder {
	
		protected Integer conditionalFixings;
		protected Boolean settlementAtKnockout;
		
		@Override
		@RosettaAttribute("conditionalFixings")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("conditionalFixings")
		public Integer getConditionalFixings() {
			return conditionalFixings;
		}
		
		@Override
		@RosettaAttribute("settlementAtKnockout")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("settlementAtKnockout")
		public Boolean getSettlementAtKnockout() {
			return settlementAtKnockout;
		}
		
		@RosettaAttribute("conditionalFixings")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("conditionalFixings")
		@Override
		public FxKnockoutCount.FxKnockoutCountBuilder setConditionalFixings(Integer _conditionalFixings) {
			this.conditionalFixings = _conditionalFixings == null ? null : _conditionalFixings;
			return this;
		}
		
		@RosettaAttribute("settlementAtKnockout")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("settlementAtKnockout")
		@Override
		public FxKnockoutCount.FxKnockoutCountBuilder setSettlementAtKnockout(Boolean _settlementAtKnockout) {
			this.settlementAtKnockout = _settlementAtKnockout == null ? null : _settlementAtKnockout;
			return this;
		}
		
		@Override
		public FxKnockoutCount build() {
			return new FxKnockoutCount.FxKnockoutCountImpl(this);
		}
		
		@Override
		public FxKnockoutCount.FxKnockoutCountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxKnockoutCount.FxKnockoutCountBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getConditionalFixings()!=null) return true;
			if (getSettlementAtKnockout()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxKnockoutCount.FxKnockoutCountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxKnockoutCount.FxKnockoutCountBuilder o = (FxKnockoutCount.FxKnockoutCountBuilder) other;
			
			
			merger.mergeBasic(getConditionalFixings(), o.getConditionalFixings(), this::setConditionalFixings);
			merger.mergeBasic(getSettlementAtKnockout(), o.getSettlementAtKnockout(), this::setSettlementAtKnockout);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxKnockoutCount _that = getType().cast(o);
		
			if (!Objects.equals(conditionalFixings, _that.getConditionalFixings())) return false;
			if (!Objects.equals(settlementAtKnockout, _that.getSettlementAtKnockout())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (conditionalFixings != null ? conditionalFixings.hashCode() : 0);
			_result = 31 * _result + (settlementAtKnockout != null ? settlementAtKnockout.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxKnockoutCountBuilder {" +
				"conditionalFixings=" + this.conditionalFixings + ", " +
				"settlementAtKnockout=" + this.settlementAtKnockout +
			'}';
		}
	}
}
