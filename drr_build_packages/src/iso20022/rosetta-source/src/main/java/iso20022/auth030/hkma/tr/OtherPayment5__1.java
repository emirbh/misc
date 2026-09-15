package iso20022.auth030.hkma.tr;

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
import com.rosetta.model.lib.records.Date;
import iso20022.auth030.hkma.tr.meta.OtherPayment5__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Payment related to elements not reported in dedicated fields.
 * @version ${project.version}
 */
@RosettaDataType(value="OtherPayment5__1", builder=OtherPayment5__1.OtherPayment5__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="OtherPayment5__1", model="iso20022", builder=OtherPayment5__1.OtherPayment5__1BuilderImpl.class, version="${project.version}")
public interface OtherPayment5__1 extends RosettaModelObject {

	OtherPayment5__1Meta metaData = new OtherPayment5__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Amount of money of any payment the reporting counterparty made or received.  Usage: The negative symbol to be used to indicate that the payment was made, not received.
	 */
	AmountAndDirection106__3 getPmtAmt();
	/**
	 * Indicates the type of other payment.
	 */
	PaymentType5Choice__1 getPmtTp();
	/**
	 * Indicates the unadjusted date on which the other payment is paid.
	 */
	Date getPmtDt();
	/**
	 * Identifies the payer of the other payment amount.
	 */
	PartyIdentification236Choice__1 getPmtPyer();
	/**
	 * Identifies the receiver of the other payment amount.
	 */
	PartyIdentification236Choice__1 getPmtRcvr();

	/*********************** Build Methods  ***********************/
	OtherPayment5__1 build();
	
	OtherPayment5__1.OtherPayment5__1Builder toBuilder();
	
	static OtherPayment5__1.OtherPayment5__1Builder builder() {
		return new OtherPayment5__1.OtherPayment5__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OtherPayment5__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OtherPayment5__1> getType() {
		return OtherPayment5__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("pmtAmt"), processor, AmountAndDirection106__3.class, getPmtAmt());
		processRosetta(path.newSubPath("pmtTp"), processor, PaymentType5Choice__1.class, getPmtTp());
		processor.processBasic(path.newSubPath("pmtDt"), Date.class, getPmtDt(), this);
		processRosetta(path.newSubPath("pmtPyer"), processor, PartyIdentification236Choice__1.class, getPmtPyer());
		processRosetta(path.newSubPath("pmtRcvr"), processor, PartyIdentification236Choice__1.class, getPmtRcvr());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OtherPayment5__1Builder extends OtherPayment5__1, RosettaModelObjectBuilder {
		AmountAndDirection106__3.AmountAndDirection106__3Builder getOrCreatePmtAmt();
		@Override
		AmountAndDirection106__3.AmountAndDirection106__3Builder getPmtAmt();
		PaymentType5Choice__1.PaymentType5Choice__1Builder getOrCreatePmtTp();
		@Override
		PaymentType5Choice__1.PaymentType5Choice__1Builder getPmtTp();
		PartyIdentification236Choice__1.PartyIdentification236Choice__1Builder getOrCreatePmtPyer();
		@Override
		PartyIdentification236Choice__1.PartyIdentification236Choice__1Builder getPmtPyer();
		PartyIdentification236Choice__1.PartyIdentification236Choice__1Builder getOrCreatePmtRcvr();
		@Override
		PartyIdentification236Choice__1.PartyIdentification236Choice__1Builder getPmtRcvr();
		OtherPayment5__1.OtherPayment5__1Builder setPmtAmt(AmountAndDirection106__3 pmtAmt);
		OtherPayment5__1.OtherPayment5__1Builder setPmtTp(PaymentType5Choice__1 pmtTp);
		OtherPayment5__1.OtherPayment5__1Builder setPmtDt(Date pmtDt);
		OtherPayment5__1.OtherPayment5__1Builder setPmtPyer(PartyIdentification236Choice__1 pmtPyer);
		OtherPayment5__1.OtherPayment5__1Builder setPmtRcvr(PartyIdentification236Choice__1 pmtRcvr);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("pmtAmt"), processor, AmountAndDirection106__3.AmountAndDirection106__3Builder.class, getPmtAmt());
			processRosetta(path.newSubPath("pmtTp"), processor, PaymentType5Choice__1.PaymentType5Choice__1Builder.class, getPmtTp());
			processor.processBasic(path.newSubPath("pmtDt"), Date.class, getPmtDt(), this);
			processRosetta(path.newSubPath("pmtPyer"), processor, PartyIdentification236Choice__1.PartyIdentification236Choice__1Builder.class, getPmtPyer());
			processRosetta(path.newSubPath("pmtRcvr"), processor, PartyIdentification236Choice__1.PartyIdentification236Choice__1Builder.class, getPmtRcvr());
		}
		

		OtherPayment5__1.OtherPayment5__1Builder prune();
	}

	/*********************** Immutable Implementation of OtherPayment5__1  ***********************/
	class OtherPayment5__1Impl implements OtherPayment5__1 {
		private final AmountAndDirection106__3 pmtAmt;
		private final PaymentType5Choice__1 pmtTp;
		private final Date pmtDt;
		private final PartyIdentification236Choice__1 pmtPyer;
		private final PartyIdentification236Choice__1 pmtRcvr;
		
		protected OtherPayment5__1Impl(OtherPayment5__1.OtherPayment5__1Builder builder) {
			this.pmtAmt = ofNullable(builder.getPmtAmt()).map(f->f.build()).orElse(null);
			this.pmtTp = ofNullable(builder.getPmtTp()).map(f->f.build()).orElse(null);
			this.pmtDt = builder.getPmtDt();
			this.pmtPyer = ofNullable(builder.getPmtPyer()).map(f->f.build()).orElse(null);
			this.pmtRcvr = ofNullable(builder.getPmtRcvr()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("pmtAmt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pmtAmt")
		public AmountAndDirection106__3 getPmtAmt() {
			return pmtAmt;
		}
		
		@Override
		@RosettaAttribute("pmtTp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("pmtTp")
		public PaymentType5Choice__1 getPmtTp() {
			return pmtTp;
		}
		
		@Override
		@RosettaAttribute("pmtDt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pmtDt")
		public Date getPmtDt() {
			return pmtDt;
		}
		
		@Override
		@RosettaAttribute("pmtPyer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pmtPyer")
		public PartyIdentification236Choice__1 getPmtPyer() {
			return pmtPyer;
		}
		
		@Override
		@RosettaAttribute("pmtRcvr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pmtRcvr")
		public PartyIdentification236Choice__1 getPmtRcvr() {
			return pmtRcvr;
		}
		
		@Override
		public OtherPayment5__1 build() {
			return this;
		}
		
		@Override
		public OtherPayment5__1.OtherPayment5__1Builder toBuilder() {
			OtherPayment5__1.OtherPayment5__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OtherPayment5__1.OtherPayment5__1Builder builder) {
			ofNullable(getPmtAmt()).ifPresent(builder::setPmtAmt);
			ofNullable(getPmtTp()).ifPresent(builder::setPmtTp);
			ofNullable(getPmtDt()).ifPresent(builder::setPmtDt);
			ofNullable(getPmtPyer()).ifPresent(builder::setPmtPyer);
			ofNullable(getPmtRcvr()).ifPresent(builder::setPmtRcvr);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OtherPayment5__1 _that = getType().cast(o);
		
			if (!Objects.equals(pmtAmt, _that.getPmtAmt())) return false;
			if (!Objects.equals(pmtTp, _that.getPmtTp())) return false;
			if (!Objects.equals(pmtDt, _that.getPmtDt())) return false;
			if (!Objects.equals(pmtPyer, _that.getPmtPyer())) return false;
			if (!Objects.equals(pmtRcvr, _that.getPmtRcvr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pmtAmt != null ? pmtAmt.hashCode() : 0);
			_result = 31 * _result + (pmtTp != null ? pmtTp.hashCode() : 0);
			_result = 31 * _result + (pmtDt != null ? pmtDt.hashCode() : 0);
			_result = 31 * _result + (pmtPyer != null ? pmtPyer.hashCode() : 0);
			_result = 31 * _result + (pmtRcvr != null ? pmtRcvr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtherPayment5__1 {" +
				"pmtAmt=" + this.pmtAmt + ", " +
				"pmtTp=" + this.pmtTp + ", " +
				"pmtDt=" + this.pmtDt + ", " +
				"pmtPyer=" + this.pmtPyer + ", " +
				"pmtRcvr=" + this.pmtRcvr +
			'}';
		}
	}

	/*********************** Builder Implementation of OtherPayment5__1  ***********************/
	class OtherPayment5__1BuilderImpl implements OtherPayment5__1.OtherPayment5__1Builder {
	
		protected AmountAndDirection106__3.AmountAndDirection106__3Builder pmtAmt;
		protected PaymentType5Choice__1.PaymentType5Choice__1Builder pmtTp;
		protected Date pmtDt;
		protected PartyIdentification236Choice__1.PartyIdentification236Choice__1Builder pmtPyer;
		protected PartyIdentification236Choice__1.PartyIdentification236Choice__1Builder pmtRcvr;
		
		@Override
		@RosettaAttribute("pmtAmt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pmtAmt")
		public AmountAndDirection106__3.AmountAndDirection106__3Builder getPmtAmt() {
			return pmtAmt;
		}
		
		@Override
		public AmountAndDirection106__3.AmountAndDirection106__3Builder getOrCreatePmtAmt() {
			AmountAndDirection106__3.AmountAndDirection106__3Builder result;
			if (pmtAmt!=null) {
				result = pmtAmt;
			}
			else {
				result = pmtAmt = AmountAndDirection106__3.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pmtTp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("pmtTp")
		public PaymentType5Choice__1.PaymentType5Choice__1Builder getPmtTp() {
			return pmtTp;
		}
		
		@Override
		public PaymentType5Choice__1.PaymentType5Choice__1Builder getOrCreatePmtTp() {
			PaymentType5Choice__1.PaymentType5Choice__1Builder result;
			if (pmtTp!=null) {
				result = pmtTp;
			}
			else {
				result = pmtTp = PaymentType5Choice__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pmtDt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pmtDt")
		public Date getPmtDt() {
			return pmtDt;
		}
		
		@Override
		@RosettaAttribute("pmtPyer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pmtPyer")
		public PartyIdentification236Choice__1.PartyIdentification236Choice__1Builder getPmtPyer() {
			return pmtPyer;
		}
		
		@Override
		public PartyIdentification236Choice__1.PartyIdentification236Choice__1Builder getOrCreatePmtPyer() {
			PartyIdentification236Choice__1.PartyIdentification236Choice__1Builder result;
			if (pmtPyer!=null) {
				result = pmtPyer;
			}
			else {
				result = pmtPyer = PartyIdentification236Choice__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pmtRcvr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pmtRcvr")
		public PartyIdentification236Choice__1.PartyIdentification236Choice__1Builder getPmtRcvr() {
			return pmtRcvr;
		}
		
		@Override
		public PartyIdentification236Choice__1.PartyIdentification236Choice__1Builder getOrCreatePmtRcvr() {
			PartyIdentification236Choice__1.PartyIdentification236Choice__1Builder result;
			if (pmtRcvr!=null) {
				result = pmtRcvr;
			}
			else {
				result = pmtRcvr = PartyIdentification236Choice__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("pmtAmt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pmtAmt")
		@Override
		public OtherPayment5__1.OtherPayment5__1Builder setPmtAmt(AmountAndDirection106__3 _pmtAmt) {
			this.pmtAmt = _pmtAmt == null ? null : _pmtAmt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pmtTp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("pmtTp")
		@Override
		public OtherPayment5__1.OtherPayment5__1Builder setPmtTp(PaymentType5Choice__1 _pmtTp) {
			this.pmtTp = _pmtTp == null ? null : _pmtTp.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pmtDt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pmtDt")
		@Override
		public OtherPayment5__1.OtherPayment5__1Builder setPmtDt(Date _pmtDt) {
			this.pmtDt = _pmtDt == null ? null : _pmtDt;
			return this;
		}
		
		@RosettaAttribute("pmtPyer")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pmtPyer")
		@Override
		public OtherPayment5__1.OtherPayment5__1Builder setPmtPyer(PartyIdentification236Choice__1 _pmtPyer) {
			this.pmtPyer = _pmtPyer == null ? null : _pmtPyer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pmtRcvr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pmtRcvr")
		@Override
		public OtherPayment5__1.OtherPayment5__1Builder setPmtRcvr(PartyIdentification236Choice__1 _pmtRcvr) {
			this.pmtRcvr = _pmtRcvr == null ? null : _pmtRcvr.toBuilder();
			return this;
		}
		
		@Override
		public OtherPayment5__1 build() {
			return new OtherPayment5__1.OtherPayment5__1Impl(this);
		}
		
		@Override
		public OtherPayment5__1.OtherPayment5__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtherPayment5__1.OtherPayment5__1Builder prune() {
			if (pmtAmt!=null && !pmtAmt.prune().hasData()) pmtAmt = null;
			if (pmtTp!=null && !pmtTp.prune().hasData()) pmtTp = null;
			if (pmtPyer!=null && !pmtPyer.prune().hasData()) pmtPyer = null;
			if (pmtRcvr!=null && !pmtRcvr.prune().hasData()) pmtRcvr = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPmtAmt()!=null && getPmtAmt().hasData()) return true;
			if (getPmtTp()!=null && getPmtTp().hasData()) return true;
			if (getPmtDt()!=null) return true;
			if (getPmtPyer()!=null && getPmtPyer().hasData()) return true;
			if (getPmtRcvr()!=null && getPmtRcvr().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtherPayment5__1.OtherPayment5__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OtherPayment5__1.OtherPayment5__1Builder o = (OtherPayment5__1.OtherPayment5__1Builder) other;
			
			merger.mergeRosetta(getPmtAmt(), o.getPmtAmt(), this::setPmtAmt);
			merger.mergeRosetta(getPmtTp(), o.getPmtTp(), this::setPmtTp);
			merger.mergeRosetta(getPmtPyer(), o.getPmtPyer(), this::setPmtPyer);
			merger.mergeRosetta(getPmtRcvr(), o.getPmtRcvr(), this::setPmtRcvr);
			
			merger.mergeBasic(getPmtDt(), o.getPmtDt(), this::setPmtDt);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OtherPayment5__1 _that = getType().cast(o);
		
			if (!Objects.equals(pmtAmt, _that.getPmtAmt())) return false;
			if (!Objects.equals(pmtTp, _that.getPmtTp())) return false;
			if (!Objects.equals(pmtDt, _that.getPmtDt())) return false;
			if (!Objects.equals(pmtPyer, _that.getPmtPyer())) return false;
			if (!Objects.equals(pmtRcvr, _that.getPmtRcvr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pmtAmt != null ? pmtAmt.hashCode() : 0);
			_result = 31 * _result + (pmtTp != null ? pmtTp.hashCode() : 0);
			_result = 31 * _result + (pmtDt != null ? pmtDt.hashCode() : 0);
			_result = 31 * _result + (pmtPyer != null ? pmtPyer.hashCode() : 0);
			_result = 31 * _result + (pmtRcvr != null ? pmtRcvr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtherPayment5__1Builder {" +
				"pmtAmt=" + this.pmtAmt + ", " +
				"pmtTp=" + this.pmtTp + ", " +
				"pmtDt=" + this.pmtDt + ", " +
				"pmtPyer=" + this.pmtPyer + ", " +
				"pmtRcvr=" + this.pmtRcvr +
			'}';
		}
	}
}
