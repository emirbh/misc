package fpml.consolidated.eq.shared;

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
import fpml.consolidated.eq.shared.meta.ReturnSwapPaymentDatesMeta;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AdjustableOrRelativeDates;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type describing the return payment dates of the swap.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing the return payment dates of the swap.
 *
 */
@RosettaDataType(value="ReturnSwapPaymentDates", builder=ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ReturnSwapPaymentDates", model="fpml", builder=ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilderImpl.class, version="2.1.1")
public interface ReturnSwapPaymentDates extends RosettaModelObject {

	ReturnSwapPaymentDatesMeta metaData = new ReturnSwapPaymentDatesMeta();

	/*********************** Getter Methods  ***********************/
	/**
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
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the interim payment dates of the swap. When defined in relation to a date specified somewhere else in the document (through the relativeDates component), this element will typically refer to the valuation dates and add a lag corresponding to the settlement cycle of the underlyer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the interim payment dates of the swap. When defined in relation to a date specified somewhere else in the document (through the relativeDates component), this element will typically refer to the valuation dates and add a lag corresponding to the settlement cycle of the underlyer.
	 *
	 */
	AdjustableOrRelativeDates getPaymentDatesInterim();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the final payment date of the swap. When defined in relation to a date specified somewhere else in the document (through the relativeDate component), this element will typically refer to the final valuation date and add a lag corresponding to the settlement cycle of the underlyer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the final payment date of the swap. When defined in relation to a date specified somewhere else in the document (through the relativeDate component), this element will typically refer to the final valuation date and add a lag corresponding to the settlement cycle of the underlyer.
	 *
	 */
	AdjustableOrRelativeDate getPaymentDateFinal();

	/*********************** Build Methods  ***********************/
	ReturnSwapPaymentDates build();
	
	ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder toBuilder();
	
	static ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder builder() {
		return new ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReturnSwapPaymentDates> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReturnSwapPaymentDates> getType() {
		return ReturnSwapPaymentDates.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("paymentDatesInterim"), processor, AdjustableOrRelativeDates.class, getPaymentDatesInterim());
		processRosetta(path.newSubPath("paymentDateFinal"), processor, AdjustableOrRelativeDate.class, getPaymentDateFinal());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReturnSwapPaymentDatesBuilder extends ReturnSwapPaymentDates, RosettaModelObjectBuilder {
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getOrCreatePaymentDatesInterim();
		@Override
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getPaymentDatesInterim();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreatePaymentDateFinal();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getPaymentDateFinal();
		ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder setId(String id);
		ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder setPaymentDatesInterim(AdjustableOrRelativeDates paymentDatesInterim);
		ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder setPaymentDateFinal(AdjustableOrRelativeDate paymentDateFinal);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("paymentDatesInterim"), processor, AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder.class, getPaymentDatesInterim());
			processRosetta(path.newSubPath("paymentDateFinal"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getPaymentDateFinal());
		}
		

		ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder prune();
	}

	/*********************** Immutable Implementation of ReturnSwapPaymentDates  ***********************/
	class ReturnSwapPaymentDatesImpl implements ReturnSwapPaymentDates {
		private final String id;
		private final AdjustableOrRelativeDates paymentDatesInterim;
		private final AdjustableOrRelativeDate paymentDateFinal;
		
		protected ReturnSwapPaymentDatesImpl(ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder builder) {
			this.id = builder.getId();
			this.paymentDatesInterim = ofNullable(builder.getPaymentDatesInterim()).map(f->f.build()).orElse(null);
			this.paymentDateFinal = ofNullable(builder.getPaymentDateFinal()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("paymentDatesInterim")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDatesInterim")
		public AdjustableOrRelativeDates getPaymentDatesInterim() {
			return paymentDatesInterim;
		}
		
		@Override
		@RosettaAttribute("paymentDateFinal")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDateFinal")
		public AdjustableOrRelativeDate getPaymentDateFinal() {
			return paymentDateFinal;
		}
		
		@Override
		public ReturnSwapPaymentDates build() {
			return this;
		}
		
		@Override
		public ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder toBuilder() {
			ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getPaymentDatesInterim()).ifPresent(builder::setPaymentDatesInterim);
			ofNullable(getPaymentDateFinal()).ifPresent(builder::setPaymentDateFinal);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReturnSwapPaymentDates _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(paymentDatesInterim, _that.getPaymentDatesInterim())) return false;
			if (!Objects.equals(paymentDateFinal, _that.getPaymentDateFinal())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (paymentDatesInterim != null ? paymentDatesInterim.hashCode() : 0);
			_result = 31 * _result + (paymentDateFinal != null ? paymentDateFinal.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnSwapPaymentDates {" +
				"id=" + this.id + ", " +
				"paymentDatesInterim=" + this.paymentDatesInterim + ", " +
				"paymentDateFinal=" + this.paymentDateFinal +
			'}';
		}
	}

	/*********************** Builder Implementation of ReturnSwapPaymentDates  ***********************/
	class ReturnSwapPaymentDatesBuilderImpl implements ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder {
	
		protected String id;
		protected AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder paymentDatesInterim;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder paymentDateFinal;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("paymentDatesInterim")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDatesInterim")
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getPaymentDatesInterim() {
			return paymentDatesInterim;
		}
		
		@Override
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getOrCreatePaymentDatesInterim() {
			AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder result;
			if (paymentDatesInterim!=null) {
				result = paymentDatesInterim;
			}
			else {
				result = paymentDatesInterim = AdjustableOrRelativeDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentDateFinal")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDateFinal")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getPaymentDateFinal() {
			return paymentDateFinal;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreatePaymentDateFinal() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (paymentDateFinal!=null) {
				result = paymentDateFinal;
			}
			else {
				result = paymentDateFinal = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("paymentDatesInterim")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentDatesInterim")
		@Override
		public ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder setPaymentDatesInterim(AdjustableOrRelativeDates _paymentDatesInterim) {
			this.paymentDatesInterim = _paymentDatesInterim == null ? null : _paymentDatesInterim.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentDateFinal")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentDateFinal")
		@Override
		public ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder setPaymentDateFinal(AdjustableOrRelativeDate _paymentDateFinal) {
			this.paymentDateFinal = _paymentDateFinal == null ? null : _paymentDateFinal.toBuilder();
			return this;
		}
		
		@Override
		public ReturnSwapPaymentDates build() {
			return new ReturnSwapPaymentDates.ReturnSwapPaymentDatesImpl(this);
		}
		
		@Override
		public ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder prune() {
			if (paymentDatesInterim!=null && !paymentDatesInterim.prune().hasData()) paymentDatesInterim = null;
			if (paymentDateFinal!=null && !paymentDateFinal.prune().hasData()) paymentDateFinal = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getPaymentDatesInterim()!=null && getPaymentDatesInterim().hasData()) return true;
			if (getPaymentDateFinal()!=null && getPaymentDateFinal().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder o = (ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder) other;
			
			merger.mergeRosetta(getPaymentDatesInterim(), o.getPaymentDatesInterim(), this::setPaymentDatesInterim);
			merger.mergeRosetta(getPaymentDateFinal(), o.getPaymentDateFinal(), this::setPaymentDateFinal);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReturnSwapPaymentDates _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(paymentDatesInterim, _that.getPaymentDatesInterim())) return false;
			if (!Objects.equals(paymentDateFinal, _that.getPaymentDateFinal())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (paymentDatesInterim != null ? paymentDatesInterim.hashCode() : 0);
			_result = 31 * _result + (paymentDateFinal != null ? paymentDateFinal.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnSwapPaymentDatesBuilder {" +
				"id=" + this.id + ", " +
				"paymentDatesInterim=" + this.paymentDatesInterim + ", " +
				"paymentDateFinal=" + this.paymentDateFinal +
			'}';
		}
	}
}
