package cdm.product.common.settlement;

import cdm.product.common.settlement.meta.PrincipalPaymentsMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.GlobalKey;
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
import com.rosetta.model.lib.annotations.RuneMetaType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class defining which principal exchanges occur for the stream.
 * @version 6.23.0
 */
@RosettaDataType(value="PrincipalPayments", builder=PrincipalPayments.PrincipalPaymentsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="PrincipalPayments", model="cdm", builder=PrincipalPayments.PrincipalPaymentsBuilderImpl.class, version="6.23.0")
public interface PrincipalPayments extends RosettaModelObject, GlobalKey {

	PrincipalPaymentsMeta metaData = new PrincipalPaymentsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A true/false flag to indicate whether there is an initial exchange of principal on the effective date.
	 */
	Boolean getInitialPayment();
	/**
	 * A true/false flag to indicate whether there is a final exchange of principal on the termination date.
	 */
	Boolean getFinalPayment();
	/**
	 * A true/false flag to indicate whether there are intermediate or interim exchanges of principal during the term of the swap.
	 */
	Boolean getIntermediatePayment();
	/**
	 * Indicate the Payout legs which nominal amount may vary in regards of FX Fixing dates as determined in the product terms.
	 */
	List<String> getVaryingLegNotionalCurrency();
	/**
	 * Describe dates schedules for Principal Exchanges and related role of the parties when known.
	 */
	PrincipalPaymentSchedule getPrincipalPaymentSchedule();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	PrincipalPayments build();
	
	PrincipalPayments.PrincipalPaymentsBuilder toBuilder();
	
	static PrincipalPayments.PrincipalPaymentsBuilder builder() {
		return new PrincipalPayments.PrincipalPaymentsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PrincipalPayments> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PrincipalPayments> getType() {
		return PrincipalPayments.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("initialPayment"), Boolean.class, getInitialPayment(), this);
		processor.processBasic(path.newSubPath("finalPayment"), Boolean.class, getFinalPayment(), this);
		processor.processBasic(path.newSubPath("intermediatePayment"), Boolean.class, getIntermediatePayment(), this);
		processor.processBasic(path.newSubPath("varyingLegNotionalCurrency"), String.class, getVaryingLegNotionalCurrency(), this);
		processRosetta(path.newSubPath("principalPaymentSchedule"), processor, PrincipalPaymentSchedule.class, getPrincipalPaymentSchedule());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PrincipalPaymentsBuilder extends PrincipalPayments, RosettaModelObjectBuilder, GlobalKey.GlobalKeyBuilder {
		PrincipalPaymentSchedule.PrincipalPaymentScheduleBuilder getOrCreatePrincipalPaymentSchedule();
		@Override
		PrincipalPaymentSchedule.PrincipalPaymentScheduleBuilder getPrincipalPaymentSchedule();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		@Override
		MetaFields.MetaFieldsBuilder getMeta();
		PrincipalPayments.PrincipalPaymentsBuilder setInitialPayment(Boolean initialPayment);
		PrincipalPayments.PrincipalPaymentsBuilder setFinalPayment(Boolean finalPayment);
		PrincipalPayments.PrincipalPaymentsBuilder setIntermediatePayment(Boolean intermediatePayment);
		PrincipalPayments.PrincipalPaymentsBuilder addVaryingLegNotionalCurrency(String varyingLegNotionalCurrency);
		PrincipalPayments.PrincipalPaymentsBuilder addVaryingLegNotionalCurrency(String varyingLegNotionalCurrency, int idx);
		PrincipalPayments.PrincipalPaymentsBuilder addVaryingLegNotionalCurrency(List<String> varyingLegNotionalCurrency);
		PrincipalPayments.PrincipalPaymentsBuilder setVaryingLegNotionalCurrency(List<String> varyingLegNotionalCurrency);
		PrincipalPayments.PrincipalPaymentsBuilder setPrincipalPaymentSchedule(PrincipalPaymentSchedule principalPaymentSchedule);
		PrincipalPayments.PrincipalPaymentsBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("initialPayment"), Boolean.class, getInitialPayment(), this);
			processor.processBasic(path.newSubPath("finalPayment"), Boolean.class, getFinalPayment(), this);
			processor.processBasic(path.newSubPath("intermediatePayment"), Boolean.class, getIntermediatePayment(), this);
			processor.processBasic(path.newSubPath("varyingLegNotionalCurrency"), String.class, getVaryingLegNotionalCurrency(), this);
			processRosetta(path.newSubPath("principalPaymentSchedule"), processor, PrincipalPaymentSchedule.PrincipalPaymentScheduleBuilder.class, getPrincipalPaymentSchedule());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		PrincipalPayments.PrincipalPaymentsBuilder prune();
	}

	/*********************** Immutable Implementation of PrincipalPayments  ***********************/
	class PrincipalPaymentsImpl implements PrincipalPayments {
		private final Boolean initialPayment;
		private final Boolean finalPayment;
		private final Boolean intermediatePayment;
		private final List<String> varyingLegNotionalCurrency;
		private final PrincipalPaymentSchedule principalPaymentSchedule;
		private final MetaFields meta;
		
		protected PrincipalPaymentsImpl(PrincipalPayments.PrincipalPaymentsBuilder builder) {
			this.initialPayment = builder.getInitialPayment();
			this.finalPayment = builder.getFinalPayment();
			this.intermediatePayment = builder.getIntermediatePayment();
			this.varyingLegNotionalCurrency = ofNullable(builder.getVaryingLegNotionalCurrency()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.principalPaymentSchedule = ofNullable(builder.getPrincipalPaymentSchedule()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("initialPayment")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("initialPayment")
		public Boolean getInitialPayment() {
			return initialPayment;
		}
		
		@Override
		@RosettaAttribute("finalPayment")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("finalPayment")
		public Boolean getFinalPayment() {
			return finalPayment;
		}
		
		@Override
		@RosettaAttribute("intermediatePayment")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("intermediatePayment")
		public Boolean getIntermediatePayment() {
			return intermediatePayment;
		}
		
		@Override
		@RosettaAttribute("varyingLegNotionalCurrency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("varyingLegNotionalCurrency")
		public List<String> getVaryingLegNotionalCurrency() {
			return varyingLegNotionalCurrency;
		}
		
		@Override
		@RosettaAttribute("principalPaymentSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("principalPaymentSchedule")
		public PrincipalPaymentSchedule getPrincipalPaymentSchedule() {
			return principalPaymentSchedule;
		}
		
		@Override
		@RosettaAttribute("meta")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public PrincipalPayments build() {
			return this;
		}
		
		@Override
		public PrincipalPayments.PrincipalPaymentsBuilder toBuilder() {
			PrincipalPayments.PrincipalPaymentsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PrincipalPayments.PrincipalPaymentsBuilder builder) {
			ofNullable(getInitialPayment()).ifPresent(builder::setInitialPayment);
			ofNullable(getFinalPayment()).ifPresent(builder::setFinalPayment);
			ofNullable(getIntermediatePayment()).ifPresent(builder::setIntermediatePayment);
			ofNullable(getVaryingLegNotionalCurrency()).ifPresent(builder::setVaryingLegNotionalCurrency);
			ofNullable(getPrincipalPaymentSchedule()).ifPresent(builder::setPrincipalPaymentSchedule);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrincipalPayments _that = getType().cast(o);
		
			if (!Objects.equals(initialPayment, _that.getInitialPayment())) return false;
			if (!Objects.equals(finalPayment, _that.getFinalPayment())) return false;
			if (!Objects.equals(intermediatePayment, _that.getIntermediatePayment())) return false;
			if (!ListEquals.listEquals(varyingLegNotionalCurrency, _that.getVaryingLegNotionalCurrency())) return false;
			if (!Objects.equals(principalPaymentSchedule, _that.getPrincipalPaymentSchedule())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initialPayment != null ? initialPayment.hashCode() : 0);
			_result = 31 * _result + (finalPayment != null ? finalPayment.hashCode() : 0);
			_result = 31 * _result + (intermediatePayment != null ? intermediatePayment.hashCode() : 0);
			_result = 31 * _result + (varyingLegNotionalCurrency != null ? varyingLegNotionalCurrency.hashCode() : 0);
			_result = 31 * _result + (principalPaymentSchedule != null ? principalPaymentSchedule.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrincipalPayments {" +
				"initialPayment=" + this.initialPayment + ", " +
				"finalPayment=" + this.finalPayment + ", " +
				"intermediatePayment=" + this.intermediatePayment + ", " +
				"varyingLegNotionalCurrency=" + this.varyingLegNotionalCurrency + ", " +
				"principalPaymentSchedule=" + this.principalPaymentSchedule + ", " +
				"meta=" + this.meta +
			'}';
		}
	}

	/*********************** Builder Implementation of PrincipalPayments  ***********************/
	class PrincipalPaymentsBuilderImpl implements PrincipalPayments.PrincipalPaymentsBuilder {
	
		protected Boolean initialPayment;
		protected Boolean finalPayment;
		protected Boolean intermediatePayment;
		protected List<String> varyingLegNotionalCurrency = new ArrayList<>();
		protected PrincipalPaymentSchedule.PrincipalPaymentScheduleBuilder principalPaymentSchedule;
		protected MetaFields.MetaFieldsBuilder meta;
		
		@Override
		@RosettaAttribute("initialPayment")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("initialPayment")
		public Boolean getInitialPayment() {
			return initialPayment;
		}
		
		@Override
		@RosettaAttribute("finalPayment")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("finalPayment")
		public Boolean getFinalPayment() {
			return finalPayment;
		}
		
		@Override
		@RosettaAttribute("intermediatePayment")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("intermediatePayment")
		public Boolean getIntermediatePayment() {
			return intermediatePayment;
		}
		
		@Override
		@RosettaAttribute("varyingLegNotionalCurrency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("varyingLegNotionalCurrency")
		public List<String> getVaryingLegNotionalCurrency() {
			return varyingLegNotionalCurrency;
		}
		
		@Override
		@RosettaAttribute("principalPaymentSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("principalPaymentSchedule")
		public PrincipalPaymentSchedule.PrincipalPaymentScheduleBuilder getPrincipalPaymentSchedule() {
			return principalPaymentSchedule;
		}
		
		@Override
		public PrincipalPaymentSchedule.PrincipalPaymentScheduleBuilder getOrCreatePrincipalPaymentSchedule() {
			PrincipalPaymentSchedule.PrincipalPaymentScheduleBuilder result;
			if (principalPaymentSchedule!=null) {
				result = principalPaymentSchedule;
			}
			else {
				result = principalPaymentSchedule = PrincipalPaymentSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("meta")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("initialPayment")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("initialPayment")
		@Override
		public PrincipalPayments.PrincipalPaymentsBuilder setInitialPayment(Boolean _initialPayment) {
			this.initialPayment = _initialPayment == null ? null : _initialPayment;
			return this;
		}
		
		@RosettaAttribute("finalPayment")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("finalPayment")
		@Override
		public PrincipalPayments.PrincipalPaymentsBuilder setFinalPayment(Boolean _finalPayment) {
			this.finalPayment = _finalPayment == null ? null : _finalPayment;
			return this;
		}
		
		@RosettaAttribute("intermediatePayment")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("intermediatePayment")
		@Override
		public PrincipalPayments.PrincipalPaymentsBuilder setIntermediatePayment(Boolean _intermediatePayment) {
			this.intermediatePayment = _intermediatePayment == null ? null : _intermediatePayment;
			return this;
		}
		
		@RosettaAttribute("varyingLegNotionalCurrency")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("varyingLegNotionalCurrency")
		@Override
		public PrincipalPayments.PrincipalPaymentsBuilder addVaryingLegNotionalCurrency(String _varyingLegNotionalCurrency) {
			if (_varyingLegNotionalCurrency != null) {
				this.varyingLegNotionalCurrency.add(_varyingLegNotionalCurrency);
			}
			return this;
		}
		
		@Override
		public PrincipalPayments.PrincipalPaymentsBuilder addVaryingLegNotionalCurrency(String _varyingLegNotionalCurrency, int idx) {
			getIndex(this.varyingLegNotionalCurrency, idx, () -> _varyingLegNotionalCurrency);
			return this;
		}
		
		@Override
		public PrincipalPayments.PrincipalPaymentsBuilder addVaryingLegNotionalCurrency(List<String> varyingLegNotionalCurrencys) {
			if (varyingLegNotionalCurrencys != null) {
				for (final String toAdd : varyingLegNotionalCurrencys) {
					this.varyingLegNotionalCurrency.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("varyingLegNotionalCurrency")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("varyingLegNotionalCurrency")
		@Override
		public PrincipalPayments.PrincipalPaymentsBuilder setVaryingLegNotionalCurrency(List<String> varyingLegNotionalCurrencys) {
			if (varyingLegNotionalCurrencys == null) {
				this.varyingLegNotionalCurrency = new ArrayList<>();
			} else {
				this.varyingLegNotionalCurrency = varyingLegNotionalCurrencys.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("principalPaymentSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("principalPaymentSchedule")
		@Override
		public PrincipalPayments.PrincipalPaymentsBuilder setPrincipalPaymentSchedule(PrincipalPaymentSchedule _principalPaymentSchedule) {
			this.principalPaymentSchedule = _principalPaymentSchedule == null ? null : _principalPaymentSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("meta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		@Override
		public PrincipalPayments.PrincipalPaymentsBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		public PrincipalPayments build() {
			return new PrincipalPayments.PrincipalPaymentsImpl(this);
		}
		
		@Override
		public PrincipalPayments.PrincipalPaymentsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrincipalPayments.PrincipalPaymentsBuilder prune() {
			if (principalPaymentSchedule!=null && !principalPaymentSchedule.prune().hasData()) principalPaymentSchedule = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInitialPayment()!=null) return true;
			if (getFinalPayment()!=null) return true;
			if (getIntermediatePayment()!=null) return true;
			if (getVaryingLegNotionalCurrency()!=null && !getVaryingLegNotionalCurrency().isEmpty()) return true;
			if (getPrincipalPaymentSchedule()!=null && getPrincipalPaymentSchedule().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrincipalPayments.PrincipalPaymentsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PrincipalPayments.PrincipalPaymentsBuilder o = (PrincipalPayments.PrincipalPaymentsBuilder) other;
			
			merger.mergeRosetta(getPrincipalPaymentSchedule(), o.getPrincipalPaymentSchedule(), this::setPrincipalPaymentSchedule);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getInitialPayment(), o.getInitialPayment(), this::setInitialPayment);
			merger.mergeBasic(getFinalPayment(), o.getFinalPayment(), this::setFinalPayment);
			merger.mergeBasic(getIntermediatePayment(), o.getIntermediatePayment(), this::setIntermediatePayment);
			merger.mergeBasic(getVaryingLegNotionalCurrency(), o.getVaryingLegNotionalCurrency(), (Consumer<String>) this::addVaryingLegNotionalCurrency);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrincipalPayments _that = getType().cast(o);
		
			if (!Objects.equals(initialPayment, _that.getInitialPayment())) return false;
			if (!Objects.equals(finalPayment, _that.getFinalPayment())) return false;
			if (!Objects.equals(intermediatePayment, _that.getIntermediatePayment())) return false;
			if (!ListEquals.listEquals(varyingLegNotionalCurrency, _that.getVaryingLegNotionalCurrency())) return false;
			if (!Objects.equals(principalPaymentSchedule, _that.getPrincipalPaymentSchedule())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initialPayment != null ? initialPayment.hashCode() : 0);
			_result = 31 * _result + (finalPayment != null ? finalPayment.hashCode() : 0);
			_result = 31 * _result + (intermediatePayment != null ? intermediatePayment.hashCode() : 0);
			_result = 31 * _result + (varyingLegNotionalCurrency != null ? varyingLegNotionalCurrency.hashCode() : 0);
			_result = 31 * _result + (principalPaymentSchedule != null ? principalPaymentSchedule.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrincipalPaymentsBuilder {" +
				"initialPayment=" + this.initialPayment + ", " +
				"finalPayment=" + this.finalPayment + ", " +
				"intermediatePayment=" + this.intermediatePayment + ", " +
				"varyingLegNotionalCurrency=" + this.varyingLegNotionalCurrency + ", " +
				"principalPaymentSchedule=" + this.principalPaymentSchedule + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
