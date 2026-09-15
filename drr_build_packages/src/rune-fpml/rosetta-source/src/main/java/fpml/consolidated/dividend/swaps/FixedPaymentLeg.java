package fpml.consolidated.dividend.swaps;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.dividend.swaps.meta.FixedPaymentLegMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.DirectionalLeg;
import fpml.consolidated.shared.LegIdentifier;
import fpml.consolidated.shared.PartyReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Fixed Payment Leg of a Dividend Swap.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Fixed Payment Leg of a Dividend Swap.
 *
 */
@RosettaDataType(value="FixedPaymentLeg", builder=FixedPaymentLeg.FixedPaymentLegBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FixedPaymentLeg", model="fpml", builder=FixedPaymentLeg.FixedPaymentLegBuilderImpl.class, version="2.1.1")
public interface FixedPaymentLeg extends DirectionalLeg {

	FixedPaymentLegMeta metaData = new FixedPaymentLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Fixed payment of a dividend swap, payment date is relative to a dividend period payment date. Commonly the dividend leg and the fixed payment leg will pay out on the same date, and the payments will be netted.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Fixed payment of a dividend swap, payment date is relative to a dividend period payment date. Commonly the dividend leg and the fixed payment leg will pay out on the same date, and the payments will be netted.
	 *
	 */
	List<? extends FixedPaymentAmount> getFixedPayment();

	/*********************** Build Methods  ***********************/
	FixedPaymentLeg build();
	
	FixedPaymentLeg.FixedPaymentLegBuilder toBuilder();
	
	static FixedPaymentLeg.FixedPaymentLegBuilder builder() {
		return new FixedPaymentLeg.FixedPaymentLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FixedPaymentLeg> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FixedPaymentLeg> getType() {
		return FixedPaymentLeg.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("legIdentifier"), processor, LegIdentifier.class, getLegIdentifier());
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.class, getTerminationDate());
		processRosetta(path.newSubPath("fixedPayment"), processor, FixedPaymentAmount.class, getFixedPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FixedPaymentLegBuilder extends FixedPaymentLeg, DirectionalLeg.DirectionalLegBuilder {
		FixedPaymentAmount.FixedPaymentAmountBuilder getOrCreateFixedPayment(int index);
		@Override
		List<? extends FixedPaymentAmount.FixedPaymentAmountBuilder> getFixedPayment();
		@Override
		FixedPaymentLeg.FixedPaymentLegBuilder setId(String id);
		@Override
		FixedPaymentLeg.FixedPaymentLegBuilder addLegIdentifier(LegIdentifier legIdentifier);
		@Override
		FixedPaymentLeg.FixedPaymentLegBuilder addLegIdentifier(LegIdentifier legIdentifier, int idx);
		@Override
		FixedPaymentLeg.FixedPaymentLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifier);
		@Override
		FixedPaymentLeg.FixedPaymentLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifier);
		@Override
		FixedPaymentLeg.FixedPaymentLegBuilder setPayerPartyReference(PartyReference payerPartyReference);
		@Override
		FixedPaymentLeg.FixedPaymentLegBuilder setPayerAccountReference(AccountReference payerAccountReference);
		@Override
		FixedPaymentLeg.FixedPaymentLegBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		@Override
		FixedPaymentLeg.FixedPaymentLegBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		@Override
		FixedPaymentLeg.FixedPaymentLegBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		@Override
		FixedPaymentLeg.FixedPaymentLegBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		FixedPaymentLeg.FixedPaymentLegBuilder addFixedPayment(FixedPaymentAmount fixedPayment);
		FixedPaymentLeg.FixedPaymentLegBuilder addFixedPayment(FixedPaymentAmount fixedPayment, int idx);
		FixedPaymentLeg.FixedPaymentLegBuilder addFixedPayment(List<? extends FixedPaymentAmount> fixedPayment);
		FixedPaymentLeg.FixedPaymentLegBuilder setFixedPayment(List<? extends FixedPaymentAmount> fixedPayment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("legIdentifier"), processor, LegIdentifier.LegIdentifierBuilder.class, getLegIdentifier());
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getTerminationDate());
			processRosetta(path.newSubPath("fixedPayment"), processor, FixedPaymentAmount.FixedPaymentAmountBuilder.class, getFixedPayment());
		}
		

		FixedPaymentLeg.FixedPaymentLegBuilder prune();
	}

	/*********************** Immutable Implementation of FixedPaymentLeg  ***********************/
	class FixedPaymentLegImpl extends DirectionalLeg.DirectionalLegImpl implements FixedPaymentLeg {
		private final List<? extends FixedPaymentAmount> fixedPayment;
		
		protected FixedPaymentLegImpl(FixedPaymentLeg.FixedPaymentLegBuilder builder) {
			super(builder);
			this.fixedPayment = ofNullable(builder.getFixedPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fixedPayment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fixedPayment")
		public List<? extends FixedPaymentAmount> getFixedPayment() {
			return fixedPayment;
		}
		
		@Override
		public FixedPaymentLeg build() {
			return this;
		}
		
		@Override
		public FixedPaymentLeg.FixedPaymentLegBuilder toBuilder() {
			FixedPaymentLeg.FixedPaymentLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FixedPaymentLeg.FixedPaymentLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFixedPayment()).ifPresent(builder::setFixedPayment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FixedPaymentLeg _that = getType().cast(o);
		
			if (!ListEquals.listEquals(fixedPayment, _that.getFixedPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixedPayment != null ? fixedPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedPaymentLeg {" +
				"fixedPayment=" + this.fixedPayment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FixedPaymentLeg  ***********************/
	class FixedPaymentLegBuilderImpl extends DirectionalLeg.DirectionalLegBuilderImpl implements FixedPaymentLeg.FixedPaymentLegBuilder {
	
		protected List<FixedPaymentAmount.FixedPaymentAmountBuilder> fixedPayment = new ArrayList<>();
		
		@Override
		@RosettaAttribute("fixedPayment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fixedPayment")
		public List<? extends FixedPaymentAmount.FixedPaymentAmountBuilder> getFixedPayment() {
			return fixedPayment;
		}
		
		@Override
		public FixedPaymentAmount.FixedPaymentAmountBuilder getOrCreateFixedPayment(int index) {
			if (fixedPayment==null) {
				this.fixedPayment = new ArrayList<>();
			}
			return getIndex(fixedPayment, index, () -> {
						FixedPaymentAmount.FixedPaymentAmountBuilder newFixedPayment = FixedPaymentAmount.builder();
						return newFixedPayment;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FixedPaymentLeg.FixedPaymentLegBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("legIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("legIdentifier")
		@Override
		public FixedPaymentLeg.FixedPaymentLegBuilder addLegIdentifier(LegIdentifier _legIdentifier) {
			if (_legIdentifier != null) {
				this.legIdentifier.add(_legIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public FixedPaymentLeg.FixedPaymentLegBuilder addLegIdentifier(LegIdentifier _legIdentifier, int idx) {
			getIndex(this.legIdentifier, idx, () -> _legIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public FixedPaymentLeg.FixedPaymentLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
			if (legIdentifiers != null) {
				for (final LegIdentifier toAdd : legIdentifiers) {
					this.legIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("legIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("legIdentifier")
		@Override
		public FixedPaymentLeg.FixedPaymentLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
			if (legIdentifiers == null) {
				this.legIdentifier = new ArrayList<>();
			} else {
				this.legIdentifier = legIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public FixedPaymentLeg.FixedPaymentLegBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public FixedPaymentLeg.FixedPaymentLegBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public FixedPaymentLeg.FixedPaymentLegBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public FixedPaymentLeg.FixedPaymentLegBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public FixedPaymentLeg.FixedPaymentLegBuilder setEffectiveDate(AdjustableOrRelativeDate _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("terminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("terminationDate")
		@Override
		public FixedPaymentLeg.FixedPaymentLegBuilder setTerminationDate(AdjustableOrRelativeDate _terminationDate) {
			this.terminationDate = _terminationDate == null ? null : _terminationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixedPayment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("fixedPayment")
		@Override
		public FixedPaymentLeg.FixedPaymentLegBuilder addFixedPayment(FixedPaymentAmount _fixedPayment) {
			if (_fixedPayment != null) {
				this.fixedPayment.add(_fixedPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public FixedPaymentLeg.FixedPaymentLegBuilder addFixedPayment(FixedPaymentAmount _fixedPayment, int idx) {
			getIndex(this.fixedPayment, idx, () -> _fixedPayment.toBuilder());
			return this;
		}
		
		@Override
		public FixedPaymentLeg.FixedPaymentLegBuilder addFixedPayment(List<? extends FixedPaymentAmount> fixedPayments) {
			if (fixedPayments != null) {
				for (final FixedPaymentAmount toAdd : fixedPayments) {
					this.fixedPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("fixedPayment")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("fixedPayment")
		@Override
		public FixedPaymentLeg.FixedPaymentLegBuilder setFixedPayment(List<? extends FixedPaymentAmount> fixedPayments) {
			if (fixedPayments == null) {
				this.fixedPayment = new ArrayList<>();
			} else {
				this.fixedPayment = fixedPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FixedPaymentLeg build() {
			return new FixedPaymentLeg.FixedPaymentLegImpl(this);
		}
		
		@Override
		public FixedPaymentLeg.FixedPaymentLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedPaymentLeg.FixedPaymentLegBuilder prune() {
			super.prune();
			fixedPayment = fixedPayment.stream().filter(b->b!=null).<FixedPaymentAmount.FixedPaymentAmountBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFixedPayment()!=null && getFixedPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedPaymentLeg.FixedPaymentLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FixedPaymentLeg.FixedPaymentLegBuilder o = (FixedPaymentLeg.FixedPaymentLegBuilder) other;
			
			merger.mergeRosetta(getFixedPayment(), o.getFixedPayment(), this::getOrCreateFixedPayment);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FixedPaymentLeg _that = getType().cast(o);
		
			if (!ListEquals.listEquals(fixedPayment, _that.getFixedPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixedPayment != null ? fixedPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedPaymentLegBuilder {" +
				"fixedPayment=" + this.fixedPayment +
			'}' + " " + super.toString();
		}
	}
}
