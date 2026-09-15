package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.UnderlyerInterestLegMeta;
import java.math.BigDecimal;
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
 * Provision A type describing interest payments associated with and underlyer, such as financing
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing interest payments associated with and underlyer, such as financing
 *
 */
@RosettaDataType(value="UnderlyerInterestLeg", builder=UnderlyerInterestLeg.UnderlyerInterestLegBuilderImpl.class, version="2.1.1")
@RuneDataType(value="UnderlyerInterestLeg", model="fpml", builder=UnderlyerInterestLeg.UnderlyerInterestLegBuilderImpl.class, version="2.1.1")
public interface UnderlyerInterestLeg extends DirectionalLeg {

	UnderlyerInterestLegMeta metaData = new UnderlyerInterestLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The calculation period fixed rate. A per annum rate, expressed as a decimal. A fixed rate of 5% would be represented as 0.05.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The calculation period fixed rate. A per annum rate, expressed as a decimal. A fixed rate of 5% would be represented as 0.05.
	 *
	 */
	BigDecimal getFixedRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The ISDA Spread or a Spread schedule expressed as explicit spreads and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The spread is a per annum rate, expressed as a decimal. For purposes of determining a calculation period amount, if positive the spread will be added to the floating rate and if negative the spread will be subtracted from the floating rate. A positive 10 basis point (0.1%) spread would be represented as 0.001.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The ISDA Spread or a Spread schedule expressed as explicit spreads and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The spread is a per annum rate, expressed as a decimal. For purposes of determining a calculation period amount, if positive the spread will be added to the floating rate and if negative the spread will be subtracted from the floating rate. A positive 10 basis point (0.1%) spread would be represented as 0.001.
	 *
	 */
	List<? extends SpreadSchedule> getSpreadSchedule();

	/*********************** Build Methods  ***********************/
	UnderlyerInterestLeg build();
	
	UnderlyerInterestLeg.UnderlyerInterestLegBuilder toBuilder();
	
	static UnderlyerInterestLeg.UnderlyerInterestLegBuilder builder() {
		return new UnderlyerInterestLeg.UnderlyerInterestLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends UnderlyerInterestLeg> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends UnderlyerInterestLeg> getType() {
		return UnderlyerInterestLeg.class;
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
		processor.processBasic(path.newSubPath("fixedRate"), BigDecimal.class, getFixedRate(), this);
		processRosetta(path.newSubPath("spreadSchedule"), processor, SpreadSchedule.class, getSpreadSchedule());
	}
	

	/*********************** Builder Interface  ***********************/
	interface UnderlyerInterestLegBuilder extends UnderlyerInterestLeg, DirectionalLeg.DirectionalLegBuilder {
		SpreadSchedule.SpreadScheduleBuilder getOrCreateSpreadSchedule(int index);
		@Override
		List<? extends SpreadSchedule.SpreadScheduleBuilder> getSpreadSchedule();
		@Override
		UnderlyerInterestLeg.UnderlyerInterestLegBuilder setId(String id);
		@Override
		UnderlyerInterestLeg.UnderlyerInterestLegBuilder addLegIdentifier(LegIdentifier legIdentifier);
		@Override
		UnderlyerInterestLeg.UnderlyerInterestLegBuilder addLegIdentifier(LegIdentifier legIdentifier, int idx);
		@Override
		UnderlyerInterestLeg.UnderlyerInterestLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifier);
		@Override
		UnderlyerInterestLeg.UnderlyerInterestLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifier);
		@Override
		UnderlyerInterestLeg.UnderlyerInterestLegBuilder setPayerPartyReference(PartyReference payerPartyReference);
		@Override
		UnderlyerInterestLeg.UnderlyerInterestLegBuilder setPayerAccountReference(AccountReference payerAccountReference);
		@Override
		UnderlyerInterestLeg.UnderlyerInterestLegBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		@Override
		UnderlyerInterestLeg.UnderlyerInterestLegBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		@Override
		UnderlyerInterestLeg.UnderlyerInterestLegBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		@Override
		UnderlyerInterestLeg.UnderlyerInterestLegBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		UnderlyerInterestLeg.UnderlyerInterestLegBuilder setFixedRate(BigDecimal fixedRate);
		UnderlyerInterestLeg.UnderlyerInterestLegBuilder addSpreadSchedule(SpreadSchedule spreadSchedule);
		UnderlyerInterestLeg.UnderlyerInterestLegBuilder addSpreadSchedule(SpreadSchedule spreadSchedule, int idx);
		UnderlyerInterestLeg.UnderlyerInterestLegBuilder addSpreadSchedule(List<? extends SpreadSchedule> spreadSchedule);
		UnderlyerInterestLeg.UnderlyerInterestLegBuilder setSpreadSchedule(List<? extends SpreadSchedule> spreadSchedule);

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
			processor.processBasic(path.newSubPath("fixedRate"), BigDecimal.class, getFixedRate(), this);
			processRosetta(path.newSubPath("spreadSchedule"), processor, SpreadSchedule.SpreadScheduleBuilder.class, getSpreadSchedule());
		}
		

		UnderlyerInterestLeg.UnderlyerInterestLegBuilder prune();
	}

	/*********************** Immutable Implementation of UnderlyerInterestLeg  ***********************/
	class UnderlyerInterestLegImpl extends DirectionalLeg.DirectionalLegImpl implements UnderlyerInterestLeg {
		private final BigDecimal fixedRate;
		private final List<? extends SpreadSchedule> spreadSchedule;
		
		protected UnderlyerInterestLegImpl(UnderlyerInterestLeg.UnderlyerInterestLegBuilder builder) {
			super(builder);
			this.fixedRate = builder.getFixedRate();
			this.spreadSchedule = ofNullable(builder.getSpreadSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRate")
		public BigDecimal getFixedRate() {
			return fixedRate;
		}
		
		@Override
		@RosettaAttribute("spreadSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("spreadSchedule")
		public List<? extends SpreadSchedule> getSpreadSchedule() {
			return spreadSchedule;
		}
		
		@Override
		public UnderlyerInterestLeg build() {
			return this;
		}
		
		@Override
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder toBuilder() {
			UnderlyerInterestLeg.UnderlyerInterestLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UnderlyerInterestLeg.UnderlyerInterestLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFixedRate()).ifPresent(builder::setFixedRate);
			ofNullable(getSpreadSchedule()).ifPresent(builder::setSpreadSchedule);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			UnderlyerInterestLeg _that = getType().cast(o);
		
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			if (!ListEquals.listEquals(spreadSchedule, _that.getSpreadSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			_result = 31 * _result + (spreadSchedule != null ? spreadSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnderlyerInterestLeg {" +
				"fixedRate=" + this.fixedRate + ", " +
				"spreadSchedule=" + this.spreadSchedule +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of UnderlyerInterestLeg  ***********************/
	class UnderlyerInterestLegBuilderImpl extends DirectionalLeg.DirectionalLegBuilderImpl implements UnderlyerInterestLeg.UnderlyerInterestLegBuilder {
	
		protected BigDecimal fixedRate;
		protected List<SpreadSchedule.SpreadScheduleBuilder> spreadSchedule = new ArrayList<>();
		
		@Override
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRate")
		public BigDecimal getFixedRate() {
			return fixedRate;
		}
		
		@Override
		@RosettaAttribute("spreadSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("spreadSchedule")
		public List<? extends SpreadSchedule.SpreadScheduleBuilder> getSpreadSchedule() {
			return spreadSchedule;
		}
		
		@Override
		public SpreadSchedule.SpreadScheduleBuilder getOrCreateSpreadSchedule(int index) {
			if (spreadSchedule==null) {
				this.spreadSchedule = new ArrayList<>();
			}
			return getIndex(spreadSchedule, index, () -> {
						SpreadSchedule.SpreadScheduleBuilder newSpreadSchedule = SpreadSchedule.builder();
						return newSpreadSchedule;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("legIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("legIdentifier")
		@Override
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder addLegIdentifier(LegIdentifier _legIdentifier) {
			if (_legIdentifier != null) {
				this.legIdentifier.add(_legIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder addLegIdentifier(LegIdentifier _legIdentifier, int idx) {
			getIndex(this.legIdentifier, idx, () -> _legIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
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
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
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
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder setEffectiveDate(AdjustableOrRelativeDate _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("terminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("terminationDate")
		@Override
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder setTerminationDate(AdjustableOrRelativeDate _terminationDate) {
			this.terminationDate = _terminationDate == null ? null : _terminationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedRate")
		@Override
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder setFixedRate(BigDecimal _fixedRate) {
			this.fixedRate = _fixedRate == null ? null : _fixedRate;
			return this;
		}
		
		@RosettaAttribute("spreadSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("spreadSchedule")
		@Override
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder addSpreadSchedule(SpreadSchedule _spreadSchedule) {
			if (_spreadSchedule != null) {
				this.spreadSchedule.add(_spreadSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder addSpreadSchedule(SpreadSchedule _spreadSchedule, int idx) {
			getIndex(this.spreadSchedule, idx, () -> _spreadSchedule.toBuilder());
			return this;
		}
		
		@Override
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder addSpreadSchedule(List<? extends SpreadSchedule> spreadSchedules) {
			if (spreadSchedules != null) {
				for (final SpreadSchedule toAdd : spreadSchedules) {
					this.spreadSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("spreadSchedule")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("spreadSchedule")
		@Override
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder setSpreadSchedule(List<? extends SpreadSchedule> spreadSchedules) {
			if (spreadSchedules == null) {
				this.spreadSchedule = new ArrayList<>();
			} else {
				this.spreadSchedule = spreadSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public UnderlyerInterestLeg build() {
			return new UnderlyerInterestLeg.UnderlyerInterestLegImpl(this);
		}
		
		@Override
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder prune() {
			super.prune();
			spreadSchedule = spreadSchedule.stream().filter(b->b!=null).<SpreadSchedule.SpreadScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFixedRate()!=null) return true;
			if (getSpreadSchedule()!=null && getSpreadSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnderlyerInterestLeg.UnderlyerInterestLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			UnderlyerInterestLeg.UnderlyerInterestLegBuilder o = (UnderlyerInterestLeg.UnderlyerInterestLegBuilder) other;
			
			merger.mergeRosetta(getSpreadSchedule(), o.getSpreadSchedule(), this::getOrCreateSpreadSchedule);
			
			merger.mergeBasic(getFixedRate(), o.getFixedRate(), this::setFixedRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			UnderlyerInterestLeg _that = getType().cast(o);
		
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			if (!ListEquals.listEquals(spreadSchedule, _that.getSpreadSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			_result = 31 * _result + (spreadSchedule != null ? spreadSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnderlyerInterestLegBuilder {" +
				"fixedRate=" + this.fixedRate + ", " +
				"spreadSchedule=" + this.spreadSchedule +
			'}' + " " + super.toString();
		}
	}
}
