package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.PaymentProjectionMeta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure that represents interest payment projections.
 *
 */
@RosettaDataType(value="PaymentProjection", builder=PaymentProjection.PaymentProjectionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PaymentProjection", model="fpml", builder=PaymentProjection.PaymentProjectionBuilderImpl.class, version="2.1.1")
public interface PaymentProjection extends RosettaModelObject {

	PaymentProjectionMeta metaData = new PaymentProjectionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The next payment for the associated event type is due on this date. This is an actual (adjusted) date.
	 *
	 */
	ZonedDateTime getNextPaymentDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Projected amount payable on the next payment date.
	 *
	 */
	MoneyWithParticipantShare getProjectedAmount();

	/*********************** Build Methods  ***********************/
	PaymentProjection build();
	
	PaymentProjection.PaymentProjectionBuilder toBuilder();
	
	static PaymentProjection.PaymentProjectionBuilder builder() {
		return new PaymentProjection.PaymentProjectionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PaymentProjection> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PaymentProjection> getType() {
		return PaymentProjection.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("nextPaymentDate"), ZonedDateTime.class, getNextPaymentDate(), this);
		processRosetta(path.newSubPath("projectedAmount"), processor, MoneyWithParticipantShare.class, getProjectedAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PaymentProjectionBuilder extends PaymentProjection, RosettaModelObjectBuilder {
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateProjectedAmount();
		@Override
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getProjectedAmount();
		PaymentProjection.PaymentProjectionBuilder setNextPaymentDate(ZonedDateTime nextPaymentDate);
		PaymentProjection.PaymentProjectionBuilder setProjectedAmount(MoneyWithParticipantShare projectedAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("nextPaymentDate"), ZonedDateTime.class, getNextPaymentDate(), this);
			processRosetta(path.newSubPath("projectedAmount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getProjectedAmount());
		}
		

		PaymentProjection.PaymentProjectionBuilder prune();
	}

	/*********************** Immutable Implementation of PaymentProjection  ***********************/
	class PaymentProjectionImpl implements PaymentProjection {
		private final ZonedDateTime nextPaymentDate;
		private final MoneyWithParticipantShare projectedAmount;
		
		protected PaymentProjectionImpl(PaymentProjection.PaymentProjectionBuilder builder) {
			this.nextPaymentDate = builder.getNextPaymentDate();
			this.projectedAmount = ofNullable(builder.getProjectedAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("nextPaymentDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("nextPaymentDate")
		public ZonedDateTime getNextPaymentDate() {
			return nextPaymentDate;
		}
		
		@Override
		@RosettaAttribute("projectedAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("projectedAmount")
		public MoneyWithParticipantShare getProjectedAmount() {
			return projectedAmount;
		}
		
		@Override
		public PaymentProjection build() {
			return this;
		}
		
		@Override
		public PaymentProjection.PaymentProjectionBuilder toBuilder() {
			PaymentProjection.PaymentProjectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PaymentProjection.PaymentProjectionBuilder builder) {
			ofNullable(getNextPaymentDate()).ifPresent(builder::setNextPaymentDate);
			ofNullable(getProjectedAmount()).ifPresent(builder::setProjectedAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaymentProjection _that = getType().cast(o);
		
			if (!Objects.equals(nextPaymentDate, _that.getNextPaymentDate())) return false;
			if (!Objects.equals(projectedAmount, _that.getProjectedAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nextPaymentDate != null ? nextPaymentDate.hashCode() : 0);
			_result = 31 * _result + (projectedAmount != null ? projectedAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentProjection {" +
				"nextPaymentDate=" + this.nextPaymentDate + ", " +
				"projectedAmount=" + this.projectedAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of PaymentProjection  ***********************/
	class PaymentProjectionBuilderImpl implements PaymentProjection.PaymentProjectionBuilder {
	
		protected ZonedDateTime nextPaymentDate;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder projectedAmount;
		
		@Override
		@RosettaAttribute("nextPaymentDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("nextPaymentDate")
		public ZonedDateTime getNextPaymentDate() {
			return nextPaymentDate;
		}
		
		@Override
		@RosettaAttribute("projectedAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("projectedAmount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getProjectedAmount() {
			return projectedAmount;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateProjectedAmount() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (projectedAmount!=null) {
				result = projectedAmount;
			}
			else {
				result = projectedAmount = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("nextPaymentDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("nextPaymentDate")
		@Override
		public PaymentProjection.PaymentProjectionBuilder setNextPaymentDate(ZonedDateTime _nextPaymentDate) {
			this.nextPaymentDate = _nextPaymentDate == null ? null : _nextPaymentDate;
			return this;
		}
		
		@RosettaAttribute("projectedAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("projectedAmount")
		@Override
		public PaymentProjection.PaymentProjectionBuilder setProjectedAmount(MoneyWithParticipantShare _projectedAmount) {
			this.projectedAmount = _projectedAmount == null ? null : _projectedAmount.toBuilder();
			return this;
		}
		
		@Override
		public PaymentProjection build() {
			return new PaymentProjection.PaymentProjectionImpl(this);
		}
		
		@Override
		public PaymentProjection.PaymentProjectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentProjection.PaymentProjectionBuilder prune() {
			if (projectedAmount!=null && !projectedAmount.prune().hasData()) projectedAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNextPaymentDate()!=null) return true;
			if (getProjectedAmount()!=null && getProjectedAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentProjection.PaymentProjectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PaymentProjection.PaymentProjectionBuilder o = (PaymentProjection.PaymentProjectionBuilder) other;
			
			merger.mergeRosetta(getProjectedAmount(), o.getProjectedAmount(), this::setProjectedAmount);
			
			merger.mergeBasic(getNextPaymentDate(), o.getNextPaymentDate(), this::setNextPaymentDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaymentProjection _that = getType().cast(o);
		
			if (!Objects.equals(nextPaymentDate, _that.getNextPaymentDate())) return false;
			if (!Objects.equals(projectedAmount, _that.getProjectedAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nextPaymentDate != null ? nextPaymentDate.hashCode() : 0);
			_result = 31 * _result + (projectedAmount != null ? projectedAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentProjectionBuilder {" +
				"nextPaymentDate=" + this.nextPaymentDate + ", " +
				"projectedAmount=" + this.projectedAmount +
			'}';
		}
	}
}
