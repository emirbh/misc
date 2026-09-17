package fpml.consolidated.cd;

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
import fpml.consolidated.cd.meta.TrancheMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision This type represents a CDS Tranche.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision This type represents a CDS Tranche.
 *
 */
@RosettaDataType(value="Tranche", builder=Tranche.TrancheBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Tranche", model="fpml", builder=Tranche.TrancheBuilderImpl.class, version="2.1.1")
public interface Tranche extends RosettaModelObject {

	TrancheMeta metaData = new TrancheMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Lower bound percentage of the loss that the Tranche can endure, expressed as a decimal. An attachment point of 5% would be represented as 0.05. The difference between Attachment and Exhaustion points is call the width of the Tranche. A schema facet to constraint the value between 0 to 1 will be introduced in FpML 4.3.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Lower bound percentage of the loss that the Tranche can endure, expressed as a decimal. An attachment point of 5% would be represented as 0.05. The difference between Attachment and Exhaustion points is call the width of the Tranche. A schema facet to constraint the value between 0 to 1 will be introduced in FpML 4.3.
	 *
	 */
	BigDecimal getAttachmentPoint();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Upper bound percentage of the loss that the Tranche can endure, expressed as a decimal. An exhaustion point of 5% would be represented as 0.05. The difference between Attachment and Exhaustion points is call the width of the Tranche. A schema facet to constraint the value between 0 to 1 will be introduced in FpML 4.3.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Upper bound percentage of the loss that the Tranche can endure, expressed as a decimal. An exhaustion point of 5% would be represented as 0.05. The difference between Attachment and Exhaustion points is call the width of the Tranche. A schema facet to constraint the value between 0 to 1 will be introduced in FpML 4.3.
	 *
	 */
	BigDecimal getExhaustionPoint();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Outstanding Swap Notional Amount is defined at any time on any day, as the greater of: (a) Zero; If Incurred Recovery Amount Applicable: (b) The Original Swap Notional Amount minus the sum of all Incurred Loss Amounts and all Incurred Recovery Amounts (if any) determined under this Confirmation at or prior to such time.Incurred Recovery Amount not populated: (b) The Original Swap Notional Amount minus the sum of all Incurred Loss Amounts determined under this Confirmation at or prior to such time.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Outstanding Swap Notional Amount is defined at any time on any day, as the greater of: (a) Zero; If Incurred Recovery Amount Applicable: (b) The Original Swap Notional Amount minus the sum of all Incurred Loss Amounts and all Incurred Recovery Amounts (if any) determined under this Confirmation at or prior to such time.Incurred Recovery Amount not populated: (b) The Original Swap Notional Amount minus the sum of all Incurred Loss Amounts determined under this Confirmation at or prior to such time.
	 *
	 */
	Boolean getIncurredRecoveryApplicable();

	/*********************** Build Methods  ***********************/
	Tranche build();
	
	Tranche.TrancheBuilder toBuilder();
	
	static Tranche.TrancheBuilder builder() {
		return new Tranche.TrancheBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Tranche> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Tranche> getType() {
		return Tranche.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("attachmentPoint"), BigDecimal.class, getAttachmentPoint(), this);
		processor.processBasic(path.newSubPath("exhaustionPoint"), BigDecimal.class, getExhaustionPoint(), this);
		processor.processBasic(path.newSubPath("incurredRecoveryApplicable"), Boolean.class, getIncurredRecoveryApplicable(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TrancheBuilder extends Tranche, RosettaModelObjectBuilder {
		Tranche.TrancheBuilder setAttachmentPoint(BigDecimal attachmentPoint);
		Tranche.TrancheBuilder setExhaustionPoint(BigDecimal exhaustionPoint);
		Tranche.TrancheBuilder setIncurredRecoveryApplicable(Boolean incurredRecoveryApplicable);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("attachmentPoint"), BigDecimal.class, getAttachmentPoint(), this);
			processor.processBasic(path.newSubPath("exhaustionPoint"), BigDecimal.class, getExhaustionPoint(), this);
			processor.processBasic(path.newSubPath("incurredRecoveryApplicable"), Boolean.class, getIncurredRecoveryApplicable(), this);
		}
		

		Tranche.TrancheBuilder prune();
	}

	/*********************** Immutable Implementation of Tranche  ***********************/
	class TrancheImpl implements Tranche {
		private final BigDecimal attachmentPoint;
		private final BigDecimal exhaustionPoint;
		private final Boolean incurredRecoveryApplicable;
		
		protected TrancheImpl(Tranche.TrancheBuilder builder) {
			this.attachmentPoint = builder.getAttachmentPoint();
			this.exhaustionPoint = builder.getExhaustionPoint();
			this.incurredRecoveryApplicable = builder.getIncurredRecoveryApplicable();
		}
		
		@Override
		@RosettaAttribute("attachmentPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("attachmentPoint")
		public BigDecimal getAttachmentPoint() {
			return attachmentPoint;
		}
		
		@Override
		@RosettaAttribute("exhaustionPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exhaustionPoint")
		public BigDecimal getExhaustionPoint() {
			return exhaustionPoint;
		}
		
		@Override
		@RosettaAttribute("incurredRecoveryApplicable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("incurredRecoveryApplicable")
		public Boolean getIncurredRecoveryApplicable() {
			return incurredRecoveryApplicable;
		}
		
		@Override
		public Tranche build() {
			return this;
		}
		
		@Override
		public Tranche.TrancheBuilder toBuilder() {
			Tranche.TrancheBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Tranche.TrancheBuilder builder) {
			ofNullable(getAttachmentPoint()).ifPresent(builder::setAttachmentPoint);
			ofNullable(getExhaustionPoint()).ifPresent(builder::setExhaustionPoint);
			ofNullable(getIncurredRecoveryApplicable()).ifPresent(builder::setIncurredRecoveryApplicable);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Tranche _that = getType().cast(o);
		
			if (!Objects.equals(attachmentPoint, _that.getAttachmentPoint())) return false;
			if (!Objects.equals(exhaustionPoint, _that.getExhaustionPoint())) return false;
			if (!Objects.equals(incurredRecoveryApplicable, _that.getIncurredRecoveryApplicable())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (attachmentPoint != null ? attachmentPoint.hashCode() : 0);
			_result = 31 * _result + (exhaustionPoint != null ? exhaustionPoint.hashCode() : 0);
			_result = 31 * _result + (incurredRecoveryApplicable != null ? incurredRecoveryApplicable.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Tranche {" +
				"attachmentPoint=" + this.attachmentPoint + ", " +
				"exhaustionPoint=" + this.exhaustionPoint + ", " +
				"incurredRecoveryApplicable=" + this.incurredRecoveryApplicable +
			'}';
		}
	}

	/*********************** Builder Implementation of Tranche  ***********************/
	class TrancheBuilderImpl implements Tranche.TrancheBuilder {
	
		protected BigDecimal attachmentPoint;
		protected BigDecimal exhaustionPoint;
		protected Boolean incurredRecoveryApplicable;
		
		@Override
		@RosettaAttribute("attachmentPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("attachmentPoint")
		public BigDecimal getAttachmentPoint() {
			return attachmentPoint;
		}
		
		@Override
		@RosettaAttribute("exhaustionPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exhaustionPoint")
		public BigDecimal getExhaustionPoint() {
			return exhaustionPoint;
		}
		
		@Override
		@RosettaAttribute("incurredRecoveryApplicable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("incurredRecoveryApplicable")
		public Boolean getIncurredRecoveryApplicable() {
			return incurredRecoveryApplicable;
		}
		
		@RosettaAttribute("attachmentPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("attachmentPoint")
		@Override
		public Tranche.TrancheBuilder setAttachmentPoint(BigDecimal _attachmentPoint) {
			this.attachmentPoint = _attachmentPoint == null ? null : _attachmentPoint;
			return this;
		}
		
		@RosettaAttribute("exhaustionPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exhaustionPoint")
		@Override
		public Tranche.TrancheBuilder setExhaustionPoint(BigDecimal _exhaustionPoint) {
			this.exhaustionPoint = _exhaustionPoint == null ? null : _exhaustionPoint;
			return this;
		}
		
		@RosettaAttribute("incurredRecoveryApplicable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("incurredRecoveryApplicable")
		@Override
		public Tranche.TrancheBuilder setIncurredRecoveryApplicable(Boolean _incurredRecoveryApplicable) {
			this.incurredRecoveryApplicable = _incurredRecoveryApplicable == null ? null : _incurredRecoveryApplicable;
			return this;
		}
		
		@Override
		public Tranche build() {
			return new Tranche.TrancheImpl(this);
		}
		
		@Override
		public Tranche.TrancheBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Tranche.TrancheBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAttachmentPoint()!=null) return true;
			if (getExhaustionPoint()!=null) return true;
			if (getIncurredRecoveryApplicable()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Tranche.TrancheBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Tranche.TrancheBuilder o = (Tranche.TrancheBuilder) other;
			
			
			merger.mergeBasic(getAttachmentPoint(), o.getAttachmentPoint(), this::setAttachmentPoint);
			merger.mergeBasic(getExhaustionPoint(), o.getExhaustionPoint(), this::setExhaustionPoint);
			merger.mergeBasic(getIncurredRecoveryApplicable(), o.getIncurredRecoveryApplicable(), this::setIncurredRecoveryApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Tranche _that = getType().cast(o);
		
			if (!Objects.equals(attachmentPoint, _that.getAttachmentPoint())) return false;
			if (!Objects.equals(exhaustionPoint, _that.getExhaustionPoint())) return false;
			if (!Objects.equals(incurredRecoveryApplicable, _that.getIncurredRecoveryApplicable())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (attachmentPoint != null ? attachmentPoint.hashCode() : 0);
			_result = 31 * _result + (exhaustionPoint != null ? exhaustionPoint.hashCode() : 0);
			_result = 31 * _result + (incurredRecoveryApplicable != null ? incurredRecoveryApplicable.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TrancheBuilder {" +
				"attachmentPoint=" + this.attachmentPoint + ", " +
				"exhaustionPoint=" + this.exhaustionPoint + ", " +
				"incurredRecoveryApplicable=" + this.incurredRecoveryApplicable +
			'}';
		}
	}
}
