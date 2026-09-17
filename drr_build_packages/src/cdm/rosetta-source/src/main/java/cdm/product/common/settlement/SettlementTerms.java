package cdm.product.common.settlement;

import cdm.product.common.settlement.meta.SettlementTermsMeta;
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
import com.rosetta.model.lib.annotations.RuneMetaType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies the settlement terms, which can either be cash, physical, or fx-based cash-settlement. This class can be used for the settlement of options and forwards, cash transactions (e.g. securities or foreign exchange), or in case of credit event.
 * @version 6.23.0
 */
@RosettaDataType(value="SettlementTerms", builder=SettlementTerms.SettlementTermsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="SettlementTerms", model="cdm", builder=SettlementTerms.SettlementTermsBuilderImpl.class, version="6.23.0")
public interface SettlementTerms extends SettlementBase {

	SettlementTermsMeta metaData = new SettlementTermsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the parameters associated with the cash settlement procedure.
	 */
	List<? extends CashSettlementTerms> getCashSettlementTerms();
	/**
	 * Specifies the physical settlement terms which apply to the transaction.
	 */
	PhysicalSettlementTerms getPhysicalSettlementTerms();

	/*********************** Build Methods  ***********************/
	SettlementTerms build();
	
	SettlementTerms.SettlementTermsBuilder toBuilder();
	
	static SettlementTerms.SettlementTermsBuilder builder() {
		return new SettlementTerms.SettlementTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementTerms> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SettlementTerms> getType() {
		return SettlementTerms.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
		processor.processBasic(path.newSubPath("transferSettlementType"), TransferSettlementEnum.class, getTransferSettlementType(), this);
		processRosetta(path.newSubPath("settlementCurrency"), processor, FieldWithMetaString.class, getSettlementCurrency());
		processRosetta(path.newSubPath("settlementDate"), processor, SettlementDate.class, getSettlementDate());
		processor.processBasic(path.newSubPath("settlementCentre"), SettlementCentreEnum.class, getSettlementCentre(), this);
		processRosetta(path.newSubPath("settlementProvision"), processor, SettlementProvision.class, getSettlementProvision());
		processor.processBasic(path.newSubPath("standardSettlementStyle"), StandardSettlementStyleEnum.class, getStandardSettlementStyle(), this);
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("cashSettlementTerms"), processor, CashSettlementTerms.class, getCashSettlementTerms());
		processRosetta(path.newSubPath("physicalSettlementTerms"), processor, PhysicalSettlementTerms.class, getPhysicalSettlementTerms());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementTermsBuilder extends SettlementTerms, SettlementBase.SettlementBaseBuilder {
		CashSettlementTerms.CashSettlementTermsBuilder getOrCreateCashSettlementTerms(int index);
		@Override
		List<? extends CashSettlementTerms.CashSettlementTermsBuilder> getCashSettlementTerms();
		PhysicalSettlementTerms.PhysicalSettlementTermsBuilder getOrCreatePhysicalSettlementTerms();
		@Override
		PhysicalSettlementTerms.PhysicalSettlementTermsBuilder getPhysicalSettlementTerms();
		@Override
		SettlementTerms.SettlementTermsBuilder setSettlementType(SettlementTypeEnum settlementType);
		@Override
		SettlementTerms.SettlementTermsBuilder setTransferSettlementType(TransferSettlementEnum transferSettlementType);
		@Override
		SettlementTerms.SettlementTermsBuilder setSettlementCurrency(FieldWithMetaString settlementCurrency);
		@Override
		SettlementTerms.SettlementTermsBuilder setSettlementCurrencyValue(String settlementCurrency);
		@Override
		SettlementTerms.SettlementTermsBuilder setSettlementDate(SettlementDate settlementDate);
		@Override
		SettlementTerms.SettlementTermsBuilder setSettlementCentre(SettlementCentreEnum settlementCentre);
		@Override
		SettlementTerms.SettlementTermsBuilder setSettlementProvision(SettlementProvision settlementProvision);
		@Override
		SettlementTerms.SettlementTermsBuilder setStandardSettlementStyle(StandardSettlementStyleEnum standardSettlementStyle);
		@Override
		SettlementTerms.SettlementTermsBuilder setMeta(MetaFields meta);
		SettlementTerms.SettlementTermsBuilder addCashSettlementTerms(CashSettlementTerms cashSettlementTerms);
		SettlementTerms.SettlementTermsBuilder addCashSettlementTerms(CashSettlementTerms cashSettlementTerms, int idx);
		SettlementTerms.SettlementTermsBuilder addCashSettlementTerms(List<? extends CashSettlementTerms> cashSettlementTerms);
		SettlementTerms.SettlementTermsBuilder setCashSettlementTerms(List<? extends CashSettlementTerms> cashSettlementTerms);
		SettlementTerms.SettlementTermsBuilder setPhysicalSettlementTerms(PhysicalSettlementTerms physicalSettlementTerms);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
			processor.processBasic(path.newSubPath("transferSettlementType"), TransferSettlementEnum.class, getTransferSettlementType(), this);
			processRosetta(path.newSubPath("settlementCurrency"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getSettlementCurrency());
			processRosetta(path.newSubPath("settlementDate"), processor, SettlementDate.SettlementDateBuilder.class, getSettlementDate());
			processor.processBasic(path.newSubPath("settlementCentre"), SettlementCentreEnum.class, getSettlementCentre(), this);
			processRosetta(path.newSubPath("settlementProvision"), processor, SettlementProvision.SettlementProvisionBuilder.class, getSettlementProvision());
			processor.processBasic(path.newSubPath("standardSettlementStyle"), StandardSettlementStyleEnum.class, getStandardSettlementStyle(), this);
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("cashSettlementTerms"), processor, CashSettlementTerms.CashSettlementTermsBuilder.class, getCashSettlementTerms());
			processRosetta(path.newSubPath("physicalSettlementTerms"), processor, PhysicalSettlementTerms.PhysicalSettlementTermsBuilder.class, getPhysicalSettlementTerms());
		}
		

		SettlementTerms.SettlementTermsBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementTerms  ***********************/
	class SettlementTermsImpl extends SettlementBase.SettlementBaseImpl implements SettlementTerms {
		private final List<? extends CashSettlementTerms> cashSettlementTerms;
		private final PhysicalSettlementTerms physicalSettlementTerms;
		
		protected SettlementTermsImpl(SettlementTerms.SettlementTermsBuilder builder) {
			super(builder);
			this.cashSettlementTerms = ofNullable(builder.getCashSettlementTerms()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.physicalSettlementTerms = ofNullable(builder.getPhysicalSettlementTerms()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("cashSettlementTerms")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cashSettlementTerms")
		public List<? extends CashSettlementTerms> getCashSettlementTerms() {
			return cashSettlementTerms;
		}
		
		@Override
		@RosettaAttribute("physicalSettlementTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalSettlementTerms")
		public PhysicalSettlementTerms getPhysicalSettlementTerms() {
			return physicalSettlementTerms;
		}
		
		@Override
		public SettlementTerms build() {
			return this;
		}
		
		@Override
		public SettlementTerms.SettlementTermsBuilder toBuilder() {
			SettlementTerms.SettlementTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementTerms.SettlementTermsBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCashSettlementTerms()).ifPresent(builder::setCashSettlementTerms);
			ofNullable(getPhysicalSettlementTerms()).ifPresent(builder::setPhysicalSettlementTerms);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SettlementTerms _that = getType().cast(o);
		
			if (!ListEquals.listEquals(cashSettlementTerms, _that.getCashSettlementTerms())) return false;
			if (!Objects.equals(physicalSettlementTerms, _that.getPhysicalSettlementTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (cashSettlementTerms != null ? cashSettlementTerms.hashCode() : 0);
			_result = 31 * _result + (physicalSettlementTerms != null ? physicalSettlementTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementTerms {" +
				"cashSettlementTerms=" + this.cashSettlementTerms + ", " +
				"physicalSettlementTerms=" + this.physicalSettlementTerms +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SettlementTerms  ***********************/
	class SettlementTermsBuilderImpl extends SettlementBase.SettlementBaseBuilderImpl implements SettlementTerms.SettlementTermsBuilder {
	
		protected List<CashSettlementTerms.CashSettlementTermsBuilder> cashSettlementTerms = new ArrayList<>();
		protected PhysicalSettlementTerms.PhysicalSettlementTermsBuilder physicalSettlementTerms;
		
		@Override
		@RosettaAttribute("cashSettlementTerms")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cashSettlementTerms")
		public List<? extends CashSettlementTerms.CashSettlementTermsBuilder> getCashSettlementTerms() {
			return cashSettlementTerms;
		}
		
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder getOrCreateCashSettlementTerms(int index) {
			if (cashSettlementTerms==null) {
				this.cashSettlementTerms = new ArrayList<>();
			}
			return getIndex(cashSettlementTerms, index, () -> {
						CashSettlementTerms.CashSettlementTermsBuilder newCashSettlementTerms = CashSettlementTerms.builder();
						return newCashSettlementTerms;
					});
		}
		
		@Override
		@RosettaAttribute("physicalSettlementTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalSettlementTerms")
		public PhysicalSettlementTerms.PhysicalSettlementTermsBuilder getPhysicalSettlementTerms() {
			return physicalSettlementTerms;
		}
		
		@Override
		public PhysicalSettlementTerms.PhysicalSettlementTermsBuilder getOrCreatePhysicalSettlementTerms() {
			PhysicalSettlementTerms.PhysicalSettlementTermsBuilder result;
			if (physicalSettlementTerms!=null) {
				result = physicalSettlementTerms;
			}
			else {
				result = physicalSettlementTerms = PhysicalSettlementTerms.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("settlementType")
		@Override
		public SettlementTerms.SettlementTermsBuilder setSettlementType(SettlementTypeEnum _settlementType) {
			this.settlementType = _settlementType == null ? null : _settlementType;
			return this;
		}
		
		@RosettaAttribute("transferSettlementType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("transferSettlementType")
		@Override
		public SettlementTerms.SettlementTermsBuilder setTransferSettlementType(TransferSettlementEnum _transferSettlementType) {
			this.transferSettlementType = _transferSettlementType == null ? null : _transferSettlementType;
			return this;
		}
		
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementCurrency")
		@Override
		public SettlementTerms.SettlementTermsBuilder setSettlementCurrency(FieldWithMetaString _settlementCurrency) {
			this.settlementCurrency = _settlementCurrency == null ? null : _settlementCurrency.toBuilder();
			return this;
		}
		
		@Override
		public SettlementTerms.SettlementTermsBuilder setSettlementCurrencyValue(String _settlementCurrency) {
			this.getOrCreateSettlementCurrency().setValue(_settlementCurrency);
			return this;
		}
		
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementDate")
		@Override
		public SettlementTerms.SettlementTermsBuilder setSettlementDate(SettlementDate _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementCentre")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementCentre")
		@Override
		public SettlementTerms.SettlementTermsBuilder setSettlementCentre(SettlementCentreEnum _settlementCentre) {
			this.settlementCentre = _settlementCentre == null ? null : _settlementCentre;
			return this;
		}
		
		@RosettaAttribute("settlementProvision")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementProvision")
		@Override
		public SettlementTerms.SettlementTermsBuilder setSettlementProvision(SettlementProvision _settlementProvision) {
			this.settlementProvision = _settlementProvision == null ? null : _settlementProvision.toBuilder();
			return this;
		}
		
		@RosettaAttribute("standardSettlementStyle")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("standardSettlementStyle")
		@Override
		public SettlementTerms.SettlementTermsBuilder setStandardSettlementStyle(StandardSettlementStyleEnum _standardSettlementStyle) {
			this.standardSettlementStyle = _standardSettlementStyle == null ? null : _standardSettlementStyle;
			return this;
		}
		
		@RosettaAttribute("meta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		@Override
		public SettlementTerms.SettlementTermsBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashSettlementTerms")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("cashSettlementTerms")
		@Override
		public SettlementTerms.SettlementTermsBuilder addCashSettlementTerms(CashSettlementTerms _cashSettlementTerms) {
			if (_cashSettlementTerms != null) {
				this.cashSettlementTerms.add(_cashSettlementTerms.toBuilder());
			}
			return this;
		}
		
		@Override
		public SettlementTerms.SettlementTermsBuilder addCashSettlementTerms(CashSettlementTerms _cashSettlementTerms, int idx) {
			getIndex(this.cashSettlementTerms, idx, () -> _cashSettlementTerms.toBuilder());
			return this;
		}
		
		@Override
		public SettlementTerms.SettlementTermsBuilder addCashSettlementTerms(List<? extends CashSettlementTerms> cashSettlementTermss) {
			if (cashSettlementTermss != null) {
				for (final CashSettlementTerms toAdd : cashSettlementTermss) {
					this.cashSettlementTerms.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("cashSettlementTerms")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("cashSettlementTerms")
		@Override
		public SettlementTerms.SettlementTermsBuilder setCashSettlementTerms(List<? extends CashSettlementTerms> cashSettlementTermss) {
			if (cashSettlementTermss == null) {
				this.cashSettlementTerms = new ArrayList<>();
			} else {
				this.cashSettlementTerms = cashSettlementTermss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("physicalSettlementTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("physicalSettlementTerms")
		@Override
		public SettlementTerms.SettlementTermsBuilder setPhysicalSettlementTerms(PhysicalSettlementTerms _physicalSettlementTerms) {
			this.physicalSettlementTerms = _physicalSettlementTerms == null ? null : _physicalSettlementTerms.toBuilder();
			return this;
		}
		
		@Override
		public SettlementTerms build() {
			return new SettlementTerms.SettlementTermsImpl(this);
		}
		
		@Override
		public SettlementTerms.SettlementTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementTerms.SettlementTermsBuilder prune() {
			super.prune();
			cashSettlementTerms = cashSettlementTerms.stream().filter(b->b!=null).<CashSettlementTerms.CashSettlementTermsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (physicalSettlementTerms!=null && !physicalSettlementTerms.prune().hasData()) physicalSettlementTerms = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCashSettlementTerms()!=null && getCashSettlementTerms().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPhysicalSettlementTerms()!=null && getPhysicalSettlementTerms().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementTerms.SettlementTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			SettlementTerms.SettlementTermsBuilder o = (SettlementTerms.SettlementTermsBuilder) other;
			
			merger.mergeRosetta(getCashSettlementTerms(), o.getCashSettlementTerms(), this::getOrCreateCashSettlementTerms);
			merger.mergeRosetta(getPhysicalSettlementTerms(), o.getPhysicalSettlementTerms(), this::setPhysicalSettlementTerms);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SettlementTerms _that = getType().cast(o);
		
			if (!ListEquals.listEquals(cashSettlementTerms, _that.getCashSettlementTerms())) return false;
			if (!Objects.equals(physicalSettlementTerms, _that.getPhysicalSettlementTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (cashSettlementTerms != null ? cashSettlementTerms.hashCode() : 0);
			_result = 31 * _result + (physicalSettlementTerms != null ? physicalSettlementTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementTermsBuilder {" +
				"cashSettlementTerms=" + this.cashSettlementTerms + ", " +
				"physicalSettlementTerms=" + this.physicalSettlementTerms +
			'}' + " " + super.toString();
		}
	}
}
