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
import fpml.consolidated.loan.meta.LoanAllocationNotificationChoice0Meta;
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
@RosettaDataType(value="LoanAllocationNotificationChoice0", builder=LoanAllocationNotificationChoice0.LoanAllocationNotificationChoice0BuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanAllocationNotificationChoice0", model="fpml", builder=LoanAllocationNotificationChoice0.LoanAllocationNotificationChoice0BuilderImpl.class, version="2.1.1")
public interface LoanAllocationNotificationChoice0 extends RosettaModelObject {

	LoanAllocationNotificationChoice0Meta metaData = new LoanAllocationNotificationChoice0Meta();

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
	AbstractLoanAllocationEvent getLoanAllocationEventGroup();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	LoanAllocationSettlementTask getSettlementTask();

	/*********************** Build Methods  ***********************/
	LoanAllocationNotificationChoice0 build();
	
	LoanAllocationNotificationChoice0.LoanAllocationNotificationChoice0Builder toBuilder();
	
	static LoanAllocationNotificationChoice0.LoanAllocationNotificationChoice0Builder builder() {
		return new LoanAllocationNotificationChoice0.LoanAllocationNotificationChoice0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationNotificationChoice0> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanAllocationNotificationChoice0> getType() {
		return LoanAllocationNotificationChoice0.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("loanAllocationEventGroup"), processor, AbstractLoanAllocationEvent.class, getLoanAllocationEventGroup());
		processRosetta(path.newSubPath("settlementTask"), processor, LoanAllocationSettlementTask.class, getSettlementTask());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationNotificationChoice0Builder extends LoanAllocationNotificationChoice0, RosettaModelObjectBuilder {
		AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder getOrCreateLoanAllocationEventGroup();
		@Override
		AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder getLoanAllocationEventGroup();
		LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder getOrCreateSettlementTask();
		@Override
		LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder getSettlementTask();
		LoanAllocationNotificationChoice0.LoanAllocationNotificationChoice0Builder setLoanAllocationEventGroup(AbstractLoanAllocationEvent loanAllocationEventGroup);
		LoanAllocationNotificationChoice0.LoanAllocationNotificationChoice0Builder setSettlementTask(LoanAllocationSettlementTask settlementTask);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("loanAllocationEventGroup"), processor, AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder.class, getLoanAllocationEventGroup());
			processRosetta(path.newSubPath("settlementTask"), processor, LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder.class, getSettlementTask());
		}
		

		LoanAllocationNotificationChoice0.LoanAllocationNotificationChoice0Builder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationNotificationChoice0  ***********************/
	class LoanAllocationNotificationChoice0Impl implements LoanAllocationNotificationChoice0 {
		private final AbstractLoanAllocationEvent loanAllocationEventGroup;
		private final LoanAllocationSettlementTask settlementTask;
		
		protected LoanAllocationNotificationChoice0Impl(LoanAllocationNotificationChoice0.LoanAllocationNotificationChoice0Builder builder) {
			this.loanAllocationEventGroup = ofNullable(builder.getLoanAllocationEventGroup()).map(f->f.build()).orElse(null);
			this.settlementTask = ofNullable(builder.getSettlementTask()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanAllocationEventGroup")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("loanAllocationEventGroup")
		public AbstractLoanAllocationEvent getLoanAllocationEventGroup() {
			return loanAllocationEventGroup;
		}
		
		@Override
		@RosettaAttribute("settlementTask")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementTask")
		public LoanAllocationSettlementTask getSettlementTask() {
			return settlementTask;
		}
		
		@Override
		public LoanAllocationNotificationChoice0 build() {
			return this;
		}
		
		@Override
		public LoanAllocationNotificationChoice0.LoanAllocationNotificationChoice0Builder toBuilder() {
			LoanAllocationNotificationChoice0.LoanAllocationNotificationChoice0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationNotificationChoice0.LoanAllocationNotificationChoice0Builder builder) {
			ofNullable(getLoanAllocationEventGroup()).ifPresent(builder::setLoanAllocationEventGroup);
			ofNullable(getSettlementTask()).ifPresent(builder::setSettlementTask);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanAllocationNotificationChoice0 _that = getType().cast(o);
		
			if (!Objects.equals(loanAllocationEventGroup, _that.getLoanAllocationEventGroup())) return false;
			if (!Objects.equals(settlementTask, _that.getSettlementTask())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (loanAllocationEventGroup != null ? loanAllocationEventGroup.hashCode() : 0);
			_result = 31 * _result + (settlementTask != null ? settlementTask.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationNotificationChoice0 {" +
				"loanAllocationEventGroup=" + this.loanAllocationEventGroup + ", " +
				"settlementTask=" + this.settlementTask +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanAllocationNotificationChoice0  ***********************/
	class LoanAllocationNotificationChoice0BuilderImpl implements LoanAllocationNotificationChoice0.LoanAllocationNotificationChoice0Builder {
	
		protected AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder loanAllocationEventGroup;
		protected LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder settlementTask;
		
		@Override
		@RosettaAttribute("loanAllocationEventGroup")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("loanAllocationEventGroup")
		public AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder getLoanAllocationEventGroup() {
			return loanAllocationEventGroup;
		}
		
		@Override
		public AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder getOrCreateLoanAllocationEventGroup() {
			AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder result;
			if (loanAllocationEventGroup!=null) {
				result = loanAllocationEventGroup;
			}
			else {
				result = loanAllocationEventGroup = AbstractLoanAllocationEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementTask")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementTask")
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder getSettlementTask() {
			return settlementTask;
		}
		
		@Override
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder getOrCreateSettlementTask() {
			LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder result;
			if (settlementTask!=null) {
				result = settlementTask;
			}
			else {
				result = settlementTask = LoanAllocationSettlementTask.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("loanAllocationEventGroup")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("loanAllocationEventGroup")
		@Override
		public LoanAllocationNotificationChoice0.LoanAllocationNotificationChoice0Builder setLoanAllocationEventGroup(AbstractLoanAllocationEvent _loanAllocationEventGroup) {
			this.loanAllocationEventGroup = _loanAllocationEventGroup == null ? null : _loanAllocationEventGroup.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementTask")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementTask")
		@Override
		public LoanAllocationNotificationChoice0.LoanAllocationNotificationChoice0Builder setSettlementTask(LoanAllocationSettlementTask _settlementTask) {
			this.settlementTask = _settlementTask == null ? null : _settlementTask.toBuilder();
			return this;
		}
		
		@Override
		public LoanAllocationNotificationChoice0 build() {
			return new LoanAllocationNotificationChoice0.LoanAllocationNotificationChoice0Impl(this);
		}
		
		@Override
		public LoanAllocationNotificationChoice0.LoanAllocationNotificationChoice0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationNotificationChoice0.LoanAllocationNotificationChoice0Builder prune() {
			if (loanAllocationEventGroup!=null && !loanAllocationEventGroup.prune().hasData()) loanAllocationEventGroup = null;
			if (settlementTask!=null && !settlementTask.prune().hasData()) settlementTask = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLoanAllocationEventGroup()!=null && getLoanAllocationEventGroup().hasData()) return true;
			if (getSettlementTask()!=null && getSettlementTask().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationNotificationChoice0.LoanAllocationNotificationChoice0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanAllocationNotificationChoice0.LoanAllocationNotificationChoice0Builder o = (LoanAllocationNotificationChoice0.LoanAllocationNotificationChoice0Builder) other;
			
			merger.mergeRosetta(getLoanAllocationEventGroup(), o.getLoanAllocationEventGroup(), this::setLoanAllocationEventGroup);
			merger.mergeRosetta(getSettlementTask(), o.getSettlementTask(), this::setSettlementTask);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanAllocationNotificationChoice0 _that = getType().cast(o);
		
			if (!Objects.equals(loanAllocationEventGroup, _that.getLoanAllocationEventGroup())) return false;
			if (!Objects.equals(settlementTask, _that.getSettlementTask())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (loanAllocationEventGroup != null ? loanAllocationEventGroup.hashCode() : 0);
			_result = 31 * _result + (settlementTask != null ? settlementTask.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationNotificationChoice0Builder {" +
				"loanAllocationEventGroup=" + this.loanAllocationEventGroup + ", " +
				"settlementTask=" + this.settlementTask +
			'}';
		}
	}
}
