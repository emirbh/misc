package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.LoanBulkServicingNotificationChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="LoanBulkServicingNotificationChoice", builder=LoanBulkServicingNotificationChoice.LoanBulkServicingNotificationChoiceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanBulkServicingNotificationChoice", model="fpml", builder=LoanBulkServicingNotificationChoice.LoanBulkServicingNotificationChoiceBuilderImpl.class, version="2.1.1")
public interface LoanBulkServicingNotificationChoice extends RosettaModelObject {

	LoanBulkServicingNotificationChoiceMeta metaData = new LoanBulkServicingNotificationChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	AbstractFacilityEvent getFacilityEventGroup();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	AbstractLcEvent getLcEventGroup();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	AbstractLoanServicingEvent getLoanContractEventGroup();

	/*********************** Build Methods  ***********************/
	LoanBulkServicingNotificationChoice build();
	
	LoanBulkServicingNotificationChoice.LoanBulkServicingNotificationChoiceBuilder toBuilder();
	
	static LoanBulkServicingNotificationChoice.LoanBulkServicingNotificationChoiceBuilder builder() {
		return new LoanBulkServicingNotificationChoice.LoanBulkServicingNotificationChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanBulkServicingNotificationChoice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanBulkServicingNotificationChoice> getType() {
		return LoanBulkServicingNotificationChoice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("facilityEventGroup"), processor, AbstractFacilityEvent.class, getFacilityEventGroup());
		processRosetta(path.newSubPath("lcEventGroup"), processor, AbstractLcEvent.class, getLcEventGroup());
		processRosetta(path.newSubPath("loanContractEventGroup"), processor, AbstractLoanServicingEvent.class, getLoanContractEventGroup());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanBulkServicingNotificationChoiceBuilder extends LoanBulkServicingNotificationChoice, RosettaModelObjectBuilder {
		AbstractFacilityEvent.AbstractFacilityEventBuilder getOrCreateFacilityEventGroup();
		@Override
		AbstractFacilityEvent.AbstractFacilityEventBuilder getFacilityEventGroup();
		AbstractLcEvent.AbstractLcEventBuilder getOrCreateLcEventGroup();
		@Override
		AbstractLcEvent.AbstractLcEventBuilder getLcEventGroup();
		AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder getOrCreateLoanContractEventGroup();
		@Override
		AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder getLoanContractEventGroup();
		LoanBulkServicingNotificationChoice.LoanBulkServicingNotificationChoiceBuilder setFacilityEventGroup(AbstractFacilityEvent facilityEventGroup);
		LoanBulkServicingNotificationChoice.LoanBulkServicingNotificationChoiceBuilder setLcEventGroup(AbstractLcEvent lcEventGroup);
		LoanBulkServicingNotificationChoice.LoanBulkServicingNotificationChoiceBuilder setLoanContractEventGroup(AbstractLoanServicingEvent loanContractEventGroup);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("facilityEventGroup"), processor, AbstractFacilityEvent.AbstractFacilityEventBuilder.class, getFacilityEventGroup());
			processRosetta(path.newSubPath("lcEventGroup"), processor, AbstractLcEvent.AbstractLcEventBuilder.class, getLcEventGroup());
			processRosetta(path.newSubPath("loanContractEventGroup"), processor, AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder.class, getLoanContractEventGroup());
		}
		

		LoanBulkServicingNotificationChoice.LoanBulkServicingNotificationChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of LoanBulkServicingNotificationChoice  ***********************/
	class LoanBulkServicingNotificationChoiceImpl implements LoanBulkServicingNotificationChoice {
		private final AbstractFacilityEvent facilityEventGroup;
		private final AbstractLcEvent lcEventGroup;
		private final AbstractLoanServicingEvent loanContractEventGroup;
		
		protected LoanBulkServicingNotificationChoiceImpl(LoanBulkServicingNotificationChoice.LoanBulkServicingNotificationChoiceBuilder builder) {
			this.facilityEventGroup = ofNullable(builder.getFacilityEventGroup()).map(f->f.build()).orElse(null);
			this.lcEventGroup = ofNullable(builder.getLcEventGroup()).map(f->f.build()).orElse(null);
			this.loanContractEventGroup = ofNullable(builder.getLoanContractEventGroup()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("facilityEventGroup")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("facilityEventGroup")
		public AbstractFacilityEvent getFacilityEventGroup() {
			return facilityEventGroup;
		}
		
		@Override
		@RosettaAttribute("lcEventGroup")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lcEventGroup")
		public AbstractLcEvent getLcEventGroup() {
			return lcEventGroup;
		}
		
		@Override
		@RosettaAttribute("loanContractEventGroup")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("loanContractEventGroup")
		public AbstractLoanServicingEvent getLoanContractEventGroup() {
			return loanContractEventGroup;
		}
		
		@Override
		public LoanBulkServicingNotificationChoice build() {
			return this;
		}
		
		@Override
		public LoanBulkServicingNotificationChoice.LoanBulkServicingNotificationChoiceBuilder toBuilder() {
			LoanBulkServicingNotificationChoice.LoanBulkServicingNotificationChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanBulkServicingNotificationChoice.LoanBulkServicingNotificationChoiceBuilder builder) {
			ofNullable(getFacilityEventGroup()).ifPresent(builder::setFacilityEventGroup);
			ofNullable(getLcEventGroup()).ifPresent(builder::setLcEventGroup);
			ofNullable(getLoanContractEventGroup()).ifPresent(builder::setLoanContractEventGroup);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanBulkServicingNotificationChoice _that = getType().cast(o);
		
			if (!Objects.equals(facilityEventGroup, _that.getFacilityEventGroup())) return false;
			if (!Objects.equals(lcEventGroup, _that.getLcEventGroup())) return false;
			if (!Objects.equals(loanContractEventGroup, _that.getLoanContractEventGroup())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (facilityEventGroup != null ? facilityEventGroup.hashCode() : 0);
			_result = 31 * _result + (lcEventGroup != null ? lcEventGroup.hashCode() : 0);
			_result = 31 * _result + (loanContractEventGroup != null ? loanContractEventGroup.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanBulkServicingNotificationChoice {" +
				"facilityEventGroup=" + this.facilityEventGroup + ", " +
				"lcEventGroup=" + this.lcEventGroup + ", " +
				"loanContractEventGroup=" + this.loanContractEventGroup +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanBulkServicingNotificationChoice  ***********************/
	class LoanBulkServicingNotificationChoiceBuilderImpl implements LoanBulkServicingNotificationChoice.LoanBulkServicingNotificationChoiceBuilder {
	
		protected AbstractFacilityEvent.AbstractFacilityEventBuilder facilityEventGroup;
		protected AbstractLcEvent.AbstractLcEventBuilder lcEventGroup;
		protected AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder loanContractEventGroup;
		
		@Override
		@RosettaAttribute("facilityEventGroup")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("facilityEventGroup")
		public AbstractFacilityEvent.AbstractFacilityEventBuilder getFacilityEventGroup() {
			return facilityEventGroup;
		}
		
		@Override
		public AbstractFacilityEvent.AbstractFacilityEventBuilder getOrCreateFacilityEventGroup() {
			AbstractFacilityEvent.AbstractFacilityEventBuilder result;
			if (facilityEventGroup!=null) {
				result = facilityEventGroup;
			}
			else {
				result = facilityEventGroup = AbstractFacilityEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lcEventGroup")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lcEventGroup")
		public AbstractLcEvent.AbstractLcEventBuilder getLcEventGroup() {
			return lcEventGroup;
		}
		
		@Override
		public AbstractLcEvent.AbstractLcEventBuilder getOrCreateLcEventGroup() {
			AbstractLcEvent.AbstractLcEventBuilder result;
			if (lcEventGroup!=null) {
				result = lcEventGroup;
			}
			else {
				result = lcEventGroup = AbstractLcEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("loanContractEventGroup")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("loanContractEventGroup")
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder getLoanContractEventGroup() {
			return loanContractEventGroup;
		}
		
		@Override
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder getOrCreateLoanContractEventGroup() {
			AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder result;
			if (loanContractEventGroup!=null) {
				result = loanContractEventGroup;
			}
			else {
				result = loanContractEventGroup = AbstractLoanServicingEvent.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("facilityEventGroup")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("facilityEventGroup")
		@Override
		public LoanBulkServicingNotificationChoice.LoanBulkServicingNotificationChoiceBuilder setFacilityEventGroup(AbstractFacilityEvent _facilityEventGroup) {
			this.facilityEventGroup = _facilityEventGroup == null ? null : _facilityEventGroup.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lcEventGroup")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lcEventGroup")
		@Override
		public LoanBulkServicingNotificationChoice.LoanBulkServicingNotificationChoiceBuilder setLcEventGroup(AbstractLcEvent _lcEventGroup) {
			this.lcEventGroup = _lcEventGroup == null ? null : _lcEventGroup.toBuilder();
			return this;
		}
		
		@RosettaAttribute("loanContractEventGroup")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("loanContractEventGroup")
		@Override
		public LoanBulkServicingNotificationChoice.LoanBulkServicingNotificationChoiceBuilder setLoanContractEventGroup(AbstractLoanServicingEvent _loanContractEventGroup) {
			this.loanContractEventGroup = _loanContractEventGroup == null ? null : _loanContractEventGroup.toBuilder();
			return this;
		}
		
		@Override
		public LoanBulkServicingNotificationChoice build() {
			return new LoanBulkServicingNotificationChoice.LoanBulkServicingNotificationChoiceImpl(this);
		}
		
		@Override
		public LoanBulkServicingNotificationChoice.LoanBulkServicingNotificationChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanBulkServicingNotificationChoice.LoanBulkServicingNotificationChoiceBuilder prune() {
			if (facilityEventGroup!=null && !facilityEventGroup.prune().hasData()) facilityEventGroup = null;
			if (lcEventGroup!=null && !lcEventGroup.prune().hasData()) lcEventGroup = null;
			if (loanContractEventGroup!=null && !loanContractEventGroup.prune().hasData()) loanContractEventGroup = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFacilityEventGroup()!=null && getFacilityEventGroup().hasData()) return true;
			if (getLcEventGroup()!=null && getLcEventGroup().hasData()) return true;
			if (getLoanContractEventGroup()!=null && getLoanContractEventGroup().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanBulkServicingNotificationChoice.LoanBulkServicingNotificationChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanBulkServicingNotificationChoice.LoanBulkServicingNotificationChoiceBuilder o = (LoanBulkServicingNotificationChoice.LoanBulkServicingNotificationChoiceBuilder) other;
			
			merger.mergeRosetta(getFacilityEventGroup(), o.getFacilityEventGroup(), this::setFacilityEventGroup);
			merger.mergeRosetta(getLcEventGroup(), o.getLcEventGroup(), this::setLcEventGroup);
			merger.mergeRosetta(getLoanContractEventGroup(), o.getLoanContractEventGroup(), this::setLoanContractEventGroup);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanBulkServicingNotificationChoice _that = getType().cast(o);
		
			if (!Objects.equals(facilityEventGroup, _that.getFacilityEventGroup())) return false;
			if (!Objects.equals(lcEventGroup, _that.getLcEventGroup())) return false;
			if (!Objects.equals(loanContractEventGroup, _that.getLoanContractEventGroup())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (facilityEventGroup != null ? facilityEventGroup.hashCode() : 0);
			_result = 31 * _result + (lcEventGroup != null ? lcEventGroup.hashCode() : 0);
			_result = 31 * _result + (loanContractEventGroup != null ? loanContractEventGroup.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanBulkServicingNotificationChoiceBuilder {" +
				"facilityEventGroup=" + this.facilityEventGroup + ", " +
				"lcEventGroup=" + this.lcEventGroup + ", " +
				"loanContractEventGroup=" + this.loanContractEventGroup +
			'}';
		}
	}
}
