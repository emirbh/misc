package fpml.consolidated.valuation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.asset.QuotationCharacteristics;
import fpml.consolidated.riskdef.SensitivitySetDefinition;
import fpml.consolidated.riskdef.ValuationScenario;
import fpml.consolidated.riskdef.ValuationScenarioReference;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.valuation.meta.ValuationSetMeta;
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
 * Provision A set of valuation inputs and results. This structure can be used for requesting valuations, or for reporting them. In general, the request fills in fewer elements.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A set of valuation inputs and results. This structure can be used for requesting valuations, or for reporting them. In general, the request fills in fewer elements.
 *
 */
@RosettaDataType(value="ValuationSet", builder=ValuationSet.ValuationSetBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ValuationSet", model="fpml", builder=ValuationSet.ValuationSetBuilderImpl.class, version="2.1.1")
public interface ValuationSet extends RosettaModelObject {

	ValuationSetMeta metaData = new ValuationSetMeta();

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
	 * Provision The name of the valuation set, used to understand what it means. E.g., "EOD Values and Risks for Party A".
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The name of the valuation set, used to understand what it means. E.g., "EOD Values and Risks for Party A".
	 *
	 */
	String getName();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Valuation scenerios used (requested/reported) in this valuation set. E.g., the EOD valuation scenario for a particular value date. Used for the first occurrence of a valuation scenario in a document.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Valuation scenerios used (requested/reported) in this valuation set. E.g., the EOD valuation scenario for a particular value date. Used for the first occurrence of a valuation scenario in a document.
	 *
	 */
	List<? extends ValuationScenario> getValuationScenario();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision References to valuation scenarios used (requested/reported) in this valuation set. E..g, a reference to the EOD valuation scenario for a particular value date. Used for subsequence occurrences of a valuation set in an FpML document.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision References to valuation scenarios used (requested/reported) in this valuation set. E..g, a reference to the EOD valuation scenario for a particular value date. Used for subsequence occurrences of a valuation set in an FpML document.
	 *
	 */
	List<? extends ValuationScenarioReference> getValuationScenarioReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to the party from whose point of view the assets are valued.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to the party from whose point of view the assets are valued.
	 *
	 */
	PartyReference getBaseParty();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Charactistics (measure types, units, sides, etc.) of the quotes used (requested/reported) in the valuation set.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Charactistics (measure types, units, sides, etc.) of the quotes used (requested/reported) in the valuation set.
	 *
	 */
	List<? extends QuotationCharacteristics> getQuotationCharacteristics();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Definition(s) of sensitivity sets used (requested or reported) in this valuation set.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Definition(s) of sensitivity sets used (requested or reported) in this valuation set.
	 *
	 */
	List<? extends SensitivitySetDefinition> getSensitivitySetDefinition();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Does this valuation set include a market environment?
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Does this valuation set include a market environment?
	 *
	 */
	ValuationSetDetail getDetail();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Valuations reported in this valuation set. These values can be values (NPVs, prices, etc.) or risks (DAR, etc.) and can include sensitivities.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Valuations reported in this valuation set. These values can be values (NPVs, prices, etc.) or risks (DAR, etc.) and can include sensitivities.
	 *
	 */
	List<? extends AssetValuation> getAssetValuation();

	/*********************** Build Methods  ***********************/
	ValuationSet build();
	
	ValuationSet.ValuationSetBuilder toBuilder();
	
	static ValuationSet.ValuationSetBuilder builder() {
		return new ValuationSet.ValuationSetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ValuationSet> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ValuationSet> getType() {
		return ValuationSet.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("valuationScenario"), processor, ValuationScenario.class, getValuationScenario());
		processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.class, getValuationScenarioReference());
		processRosetta(path.newSubPath("baseParty"), processor, PartyReference.class, getBaseParty());
		processRosetta(path.newSubPath("quotationCharacteristics"), processor, QuotationCharacteristics.class, getQuotationCharacteristics());
		processRosetta(path.newSubPath("sensitivitySetDefinition"), processor, SensitivitySetDefinition.class, getSensitivitySetDefinition());
		processRosetta(path.newSubPath("detail"), processor, ValuationSetDetail.class, getDetail());
		processRosetta(path.newSubPath("assetValuation"), processor, AssetValuation.class, getAssetValuation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ValuationSetBuilder extends ValuationSet, RosettaModelObjectBuilder {
		ValuationScenario.ValuationScenarioBuilder getOrCreateValuationScenario(int index);
		@Override
		List<? extends ValuationScenario.ValuationScenarioBuilder> getValuationScenario();
		ValuationScenarioReference.ValuationScenarioReferenceBuilder getOrCreateValuationScenarioReference(int index);
		@Override
		List<? extends ValuationScenarioReference.ValuationScenarioReferenceBuilder> getValuationScenarioReference();
		PartyReference.PartyReferenceBuilder getOrCreateBaseParty();
		@Override
		PartyReference.PartyReferenceBuilder getBaseParty();
		QuotationCharacteristics.QuotationCharacteristicsBuilder getOrCreateQuotationCharacteristics(int index);
		@Override
		List<? extends QuotationCharacteristics.QuotationCharacteristicsBuilder> getQuotationCharacteristics();
		SensitivitySetDefinition.SensitivitySetDefinitionBuilder getOrCreateSensitivitySetDefinition(int index);
		@Override
		List<? extends SensitivitySetDefinition.SensitivitySetDefinitionBuilder> getSensitivitySetDefinition();
		ValuationSetDetail.ValuationSetDetailBuilder getOrCreateDetail();
		@Override
		ValuationSetDetail.ValuationSetDetailBuilder getDetail();
		AssetValuation.AssetValuationBuilder getOrCreateAssetValuation(int index);
		@Override
		List<? extends AssetValuation.AssetValuationBuilder> getAssetValuation();
		ValuationSet.ValuationSetBuilder setId(String id);
		ValuationSet.ValuationSetBuilder setName(String name);
		ValuationSet.ValuationSetBuilder addValuationScenario(ValuationScenario valuationScenario);
		ValuationSet.ValuationSetBuilder addValuationScenario(ValuationScenario valuationScenario, int idx);
		ValuationSet.ValuationSetBuilder addValuationScenario(List<? extends ValuationScenario> valuationScenario);
		ValuationSet.ValuationSetBuilder setValuationScenario(List<? extends ValuationScenario> valuationScenario);
		ValuationSet.ValuationSetBuilder addValuationScenarioReference(ValuationScenarioReference valuationScenarioReference);
		ValuationSet.ValuationSetBuilder addValuationScenarioReference(ValuationScenarioReference valuationScenarioReference, int idx);
		ValuationSet.ValuationSetBuilder addValuationScenarioReference(List<? extends ValuationScenarioReference> valuationScenarioReference);
		ValuationSet.ValuationSetBuilder setValuationScenarioReference(List<? extends ValuationScenarioReference> valuationScenarioReference);
		ValuationSet.ValuationSetBuilder setBaseParty(PartyReference baseParty);
		ValuationSet.ValuationSetBuilder addQuotationCharacteristics(QuotationCharacteristics quotationCharacteristics);
		ValuationSet.ValuationSetBuilder addQuotationCharacteristics(QuotationCharacteristics quotationCharacteristics, int idx);
		ValuationSet.ValuationSetBuilder addQuotationCharacteristics(List<? extends QuotationCharacteristics> quotationCharacteristics);
		ValuationSet.ValuationSetBuilder setQuotationCharacteristics(List<? extends QuotationCharacteristics> quotationCharacteristics);
		ValuationSet.ValuationSetBuilder addSensitivitySetDefinition(SensitivitySetDefinition sensitivitySetDefinition);
		ValuationSet.ValuationSetBuilder addSensitivitySetDefinition(SensitivitySetDefinition sensitivitySetDefinition, int idx);
		ValuationSet.ValuationSetBuilder addSensitivitySetDefinition(List<? extends SensitivitySetDefinition> sensitivitySetDefinition);
		ValuationSet.ValuationSetBuilder setSensitivitySetDefinition(List<? extends SensitivitySetDefinition> sensitivitySetDefinition);
		ValuationSet.ValuationSetBuilder setDetail(ValuationSetDetail detail);
		ValuationSet.ValuationSetBuilder addAssetValuation(AssetValuation assetValuation);
		ValuationSet.ValuationSetBuilder addAssetValuation(AssetValuation assetValuation, int idx);
		ValuationSet.ValuationSetBuilder addAssetValuation(List<? extends AssetValuation> assetValuation);
		ValuationSet.ValuationSetBuilder setAssetValuation(List<? extends AssetValuation> assetValuation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("valuationScenario"), processor, ValuationScenario.ValuationScenarioBuilder.class, getValuationScenario());
			processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.ValuationScenarioReferenceBuilder.class, getValuationScenarioReference());
			processRosetta(path.newSubPath("baseParty"), processor, PartyReference.PartyReferenceBuilder.class, getBaseParty());
			processRosetta(path.newSubPath("quotationCharacteristics"), processor, QuotationCharacteristics.QuotationCharacteristicsBuilder.class, getQuotationCharacteristics());
			processRosetta(path.newSubPath("sensitivitySetDefinition"), processor, SensitivitySetDefinition.SensitivitySetDefinitionBuilder.class, getSensitivitySetDefinition());
			processRosetta(path.newSubPath("detail"), processor, ValuationSetDetail.ValuationSetDetailBuilder.class, getDetail());
			processRosetta(path.newSubPath("assetValuation"), processor, AssetValuation.AssetValuationBuilder.class, getAssetValuation());
		}
		

		ValuationSet.ValuationSetBuilder prune();
	}

	/*********************** Immutable Implementation of ValuationSet  ***********************/
	class ValuationSetImpl implements ValuationSet {
		private final String id;
		private final String name;
		private final List<? extends ValuationScenario> valuationScenario;
		private final List<? extends ValuationScenarioReference> valuationScenarioReference;
		private final PartyReference baseParty;
		private final List<? extends QuotationCharacteristics> quotationCharacteristics;
		private final List<? extends SensitivitySetDefinition> sensitivitySetDefinition;
		private final ValuationSetDetail detail;
		private final List<? extends AssetValuation> assetValuation;
		
		protected ValuationSetImpl(ValuationSet.ValuationSetBuilder builder) {
			this.id = builder.getId();
			this.name = builder.getName();
			this.valuationScenario = ofNullable(builder.getValuationScenario()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.valuationScenarioReference = ofNullable(builder.getValuationScenarioReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.baseParty = ofNullable(builder.getBaseParty()).map(f->f.build()).orElse(null);
			this.quotationCharacteristics = ofNullable(builder.getQuotationCharacteristics()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.sensitivitySetDefinition = ofNullable(builder.getSensitivitySetDefinition()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.detail = ofNullable(builder.getDetail()).map(f->f.build()).orElse(null);
			this.assetValuation = ofNullable(builder.getAssetValuation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("valuationScenario")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("valuationScenario")
		public List<? extends ValuationScenario> getValuationScenario() {
			return valuationScenario;
		}
		
		@Override
		@RosettaAttribute("valuationScenarioReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("valuationScenarioReference")
		public List<? extends ValuationScenarioReference> getValuationScenarioReference() {
			return valuationScenarioReference;
		}
		
		@Override
		@RosettaAttribute("baseParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("baseParty")
		public PartyReference getBaseParty() {
			return baseParty;
		}
		
		@Override
		@RosettaAttribute("quotationCharacteristics")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("quotationCharacteristics")
		public List<? extends QuotationCharacteristics> getQuotationCharacteristics() {
			return quotationCharacteristics;
		}
		
		@Override
		@RosettaAttribute("sensitivitySetDefinition")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("sensitivitySetDefinition")
		public List<? extends SensitivitySetDefinition> getSensitivitySetDefinition() {
			return sensitivitySetDefinition;
		}
		
		@Override
		@RosettaAttribute("detail")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("detail")
		public ValuationSetDetail getDetail() {
			return detail;
		}
		
		@Override
		@RosettaAttribute("assetValuation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("assetValuation")
		public List<? extends AssetValuation> getAssetValuation() {
			return assetValuation;
		}
		
		@Override
		public ValuationSet build() {
			return this;
		}
		
		@Override
		public ValuationSet.ValuationSetBuilder toBuilder() {
			ValuationSet.ValuationSetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ValuationSet.ValuationSetBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getValuationScenario()).ifPresent(builder::setValuationScenario);
			ofNullable(getValuationScenarioReference()).ifPresent(builder::setValuationScenarioReference);
			ofNullable(getBaseParty()).ifPresent(builder::setBaseParty);
			ofNullable(getQuotationCharacteristics()).ifPresent(builder::setQuotationCharacteristics);
			ofNullable(getSensitivitySetDefinition()).ifPresent(builder::setSensitivitySetDefinition);
			ofNullable(getDetail()).ifPresent(builder::setDetail);
			ofNullable(getAssetValuation()).ifPresent(builder::setAssetValuation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValuationSet _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!ListEquals.listEquals(valuationScenario, _that.getValuationScenario())) return false;
			if (!ListEquals.listEquals(valuationScenarioReference, _that.getValuationScenarioReference())) return false;
			if (!Objects.equals(baseParty, _that.getBaseParty())) return false;
			if (!ListEquals.listEquals(quotationCharacteristics, _that.getQuotationCharacteristics())) return false;
			if (!ListEquals.listEquals(sensitivitySetDefinition, _that.getSensitivitySetDefinition())) return false;
			if (!Objects.equals(detail, _that.getDetail())) return false;
			if (!ListEquals.listEquals(assetValuation, _that.getAssetValuation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (valuationScenario != null ? valuationScenario.hashCode() : 0);
			_result = 31 * _result + (valuationScenarioReference != null ? valuationScenarioReference.hashCode() : 0);
			_result = 31 * _result + (baseParty != null ? baseParty.hashCode() : 0);
			_result = 31 * _result + (quotationCharacteristics != null ? quotationCharacteristics.hashCode() : 0);
			_result = 31 * _result + (sensitivitySetDefinition != null ? sensitivitySetDefinition.hashCode() : 0);
			_result = 31 * _result + (detail != null ? detail.hashCode() : 0);
			_result = 31 * _result + (assetValuation != null ? assetValuation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationSet {" +
				"id=" + this.id + ", " +
				"name=" + this.name + ", " +
				"valuationScenario=" + this.valuationScenario + ", " +
				"valuationScenarioReference=" + this.valuationScenarioReference + ", " +
				"baseParty=" + this.baseParty + ", " +
				"quotationCharacteristics=" + this.quotationCharacteristics + ", " +
				"sensitivitySetDefinition=" + this.sensitivitySetDefinition + ", " +
				"detail=" + this.detail + ", " +
				"assetValuation=" + this.assetValuation +
			'}';
		}
	}

	/*********************** Builder Implementation of ValuationSet  ***********************/
	class ValuationSetBuilderImpl implements ValuationSet.ValuationSetBuilder {
	
		protected String id;
		protected String name;
		protected List<ValuationScenario.ValuationScenarioBuilder> valuationScenario = new ArrayList<>();
		protected List<ValuationScenarioReference.ValuationScenarioReferenceBuilder> valuationScenarioReference = new ArrayList<>();
		protected PartyReference.PartyReferenceBuilder baseParty;
		protected List<QuotationCharacteristics.QuotationCharacteristicsBuilder> quotationCharacteristics = new ArrayList<>();
		protected List<SensitivitySetDefinition.SensitivitySetDefinitionBuilder> sensitivitySetDefinition = new ArrayList<>();
		protected ValuationSetDetail.ValuationSetDetailBuilder detail;
		protected List<AssetValuation.AssetValuationBuilder> assetValuation = new ArrayList<>();
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("valuationScenario")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("valuationScenario")
		public List<? extends ValuationScenario.ValuationScenarioBuilder> getValuationScenario() {
			return valuationScenario;
		}
		
		@Override
		public ValuationScenario.ValuationScenarioBuilder getOrCreateValuationScenario(int index) {
			if (valuationScenario==null) {
				this.valuationScenario = new ArrayList<>();
			}
			return getIndex(valuationScenario, index, () -> {
						ValuationScenario.ValuationScenarioBuilder newValuationScenario = ValuationScenario.builder();
						return newValuationScenario;
					});
		}
		
		@Override
		@RosettaAttribute("valuationScenarioReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("valuationScenarioReference")
		public List<? extends ValuationScenarioReference.ValuationScenarioReferenceBuilder> getValuationScenarioReference() {
			return valuationScenarioReference;
		}
		
		@Override
		public ValuationScenarioReference.ValuationScenarioReferenceBuilder getOrCreateValuationScenarioReference(int index) {
			if (valuationScenarioReference==null) {
				this.valuationScenarioReference = new ArrayList<>();
			}
			return getIndex(valuationScenarioReference, index, () -> {
						ValuationScenarioReference.ValuationScenarioReferenceBuilder newValuationScenarioReference = ValuationScenarioReference.builder();
						return newValuationScenarioReference;
					});
		}
		
		@Override
		@RosettaAttribute("baseParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("baseParty")
		public PartyReference.PartyReferenceBuilder getBaseParty() {
			return baseParty;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateBaseParty() {
			PartyReference.PartyReferenceBuilder result;
			if (baseParty!=null) {
				result = baseParty;
			}
			else {
				result = baseParty = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quotationCharacteristics")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("quotationCharacteristics")
		public List<? extends QuotationCharacteristics.QuotationCharacteristicsBuilder> getQuotationCharacteristics() {
			return quotationCharacteristics;
		}
		
		@Override
		public QuotationCharacteristics.QuotationCharacteristicsBuilder getOrCreateQuotationCharacteristics(int index) {
			if (quotationCharacteristics==null) {
				this.quotationCharacteristics = new ArrayList<>();
			}
			return getIndex(quotationCharacteristics, index, () -> {
						QuotationCharacteristics.QuotationCharacteristicsBuilder newQuotationCharacteristics = QuotationCharacteristics.builder();
						return newQuotationCharacteristics;
					});
		}
		
		@Override
		@RosettaAttribute("sensitivitySetDefinition")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("sensitivitySetDefinition")
		public List<? extends SensitivitySetDefinition.SensitivitySetDefinitionBuilder> getSensitivitySetDefinition() {
			return sensitivitySetDefinition;
		}
		
		@Override
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder getOrCreateSensitivitySetDefinition(int index) {
			if (sensitivitySetDefinition==null) {
				this.sensitivitySetDefinition = new ArrayList<>();
			}
			return getIndex(sensitivitySetDefinition, index, () -> {
						SensitivitySetDefinition.SensitivitySetDefinitionBuilder newSensitivitySetDefinition = SensitivitySetDefinition.builder();
						return newSensitivitySetDefinition;
					});
		}
		
		@Override
		@RosettaAttribute("detail")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("detail")
		public ValuationSetDetail.ValuationSetDetailBuilder getDetail() {
			return detail;
		}
		
		@Override
		public ValuationSetDetail.ValuationSetDetailBuilder getOrCreateDetail() {
			ValuationSetDetail.ValuationSetDetailBuilder result;
			if (detail!=null) {
				result = detail;
			}
			else {
				result = detail = ValuationSetDetail.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("assetValuation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("assetValuation")
		public List<? extends AssetValuation.AssetValuationBuilder> getAssetValuation() {
			return assetValuation;
		}
		
		@Override
		public AssetValuation.AssetValuationBuilder getOrCreateAssetValuation(int index) {
			if (assetValuation==null) {
				this.assetValuation = new ArrayList<>();
			}
			return getIndex(assetValuation, index, () -> {
						AssetValuation.AssetValuationBuilder newAssetValuation = AssetValuation.builder();
						return newAssetValuation;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public ValuationSet.ValuationSetBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("name")
		@Override
		public ValuationSet.ValuationSetBuilder setName(String _name) {
			this.name = _name == null ? null : _name;
			return this;
		}
		
		@RosettaAttribute("valuationScenario")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("valuationScenario")
		@Override
		public ValuationSet.ValuationSetBuilder addValuationScenario(ValuationScenario _valuationScenario) {
			if (_valuationScenario != null) {
				this.valuationScenario.add(_valuationScenario.toBuilder());
			}
			return this;
		}
		
		@Override
		public ValuationSet.ValuationSetBuilder addValuationScenario(ValuationScenario _valuationScenario, int idx) {
			getIndex(this.valuationScenario, idx, () -> _valuationScenario.toBuilder());
			return this;
		}
		
		@Override
		public ValuationSet.ValuationSetBuilder addValuationScenario(List<? extends ValuationScenario> valuationScenarios) {
			if (valuationScenarios != null) {
				for (final ValuationScenario toAdd : valuationScenarios) {
					this.valuationScenario.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("valuationScenario")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("valuationScenario")
		@Override
		public ValuationSet.ValuationSetBuilder setValuationScenario(List<? extends ValuationScenario> valuationScenarios) {
			if (valuationScenarios == null) {
				this.valuationScenario = new ArrayList<>();
			} else {
				this.valuationScenario = valuationScenarios.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("valuationScenarioReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("valuationScenarioReference")
		@Override
		public ValuationSet.ValuationSetBuilder addValuationScenarioReference(ValuationScenarioReference _valuationScenarioReference) {
			if (_valuationScenarioReference != null) {
				this.valuationScenarioReference.add(_valuationScenarioReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public ValuationSet.ValuationSetBuilder addValuationScenarioReference(ValuationScenarioReference _valuationScenarioReference, int idx) {
			getIndex(this.valuationScenarioReference, idx, () -> _valuationScenarioReference.toBuilder());
			return this;
		}
		
		@Override
		public ValuationSet.ValuationSetBuilder addValuationScenarioReference(List<? extends ValuationScenarioReference> valuationScenarioReferences) {
			if (valuationScenarioReferences != null) {
				for (final ValuationScenarioReference toAdd : valuationScenarioReferences) {
					this.valuationScenarioReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("valuationScenarioReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("valuationScenarioReference")
		@Override
		public ValuationSet.ValuationSetBuilder setValuationScenarioReference(List<? extends ValuationScenarioReference> valuationScenarioReferences) {
			if (valuationScenarioReferences == null) {
				this.valuationScenarioReference = new ArrayList<>();
			} else {
				this.valuationScenarioReference = valuationScenarioReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("baseParty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("baseParty")
		@Override
		public ValuationSet.ValuationSetBuilder setBaseParty(PartyReference _baseParty) {
			this.baseParty = _baseParty == null ? null : _baseParty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quotationCharacteristics")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("quotationCharacteristics")
		@Override
		public ValuationSet.ValuationSetBuilder addQuotationCharacteristics(QuotationCharacteristics _quotationCharacteristics) {
			if (_quotationCharacteristics != null) {
				this.quotationCharacteristics.add(_quotationCharacteristics.toBuilder());
			}
			return this;
		}
		
		@Override
		public ValuationSet.ValuationSetBuilder addQuotationCharacteristics(QuotationCharacteristics _quotationCharacteristics, int idx) {
			getIndex(this.quotationCharacteristics, idx, () -> _quotationCharacteristics.toBuilder());
			return this;
		}
		
		@Override
		public ValuationSet.ValuationSetBuilder addQuotationCharacteristics(List<? extends QuotationCharacteristics> quotationCharacteristicss) {
			if (quotationCharacteristicss != null) {
				for (final QuotationCharacteristics toAdd : quotationCharacteristicss) {
					this.quotationCharacteristics.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("quotationCharacteristics")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("quotationCharacteristics")
		@Override
		public ValuationSet.ValuationSetBuilder setQuotationCharacteristics(List<? extends QuotationCharacteristics> quotationCharacteristicss) {
			if (quotationCharacteristicss == null) {
				this.quotationCharacteristics = new ArrayList<>();
			} else {
				this.quotationCharacteristics = quotationCharacteristicss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("sensitivitySetDefinition")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("sensitivitySetDefinition")
		@Override
		public ValuationSet.ValuationSetBuilder addSensitivitySetDefinition(SensitivitySetDefinition _sensitivitySetDefinition) {
			if (_sensitivitySetDefinition != null) {
				this.sensitivitySetDefinition.add(_sensitivitySetDefinition.toBuilder());
			}
			return this;
		}
		
		@Override
		public ValuationSet.ValuationSetBuilder addSensitivitySetDefinition(SensitivitySetDefinition _sensitivitySetDefinition, int idx) {
			getIndex(this.sensitivitySetDefinition, idx, () -> _sensitivitySetDefinition.toBuilder());
			return this;
		}
		
		@Override
		public ValuationSet.ValuationSetBuilder addSensitivitySetDefinition(List<? extends SensitivitySetDefinition> sensitivitySetDefinitions) {
			if (sensitivitySetDefinitions != null) {
				for (final SensitivitySetDefinition toAdd : sensitivitySetDefinitions) {
					this.sensitivitySetDefinition.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("sensitivitySetDefinition")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("sensitivitySetDefinition")
		@Override
		public ValuationSet.ValuationSetBuilder setSensitivitySetDefinition(List<? extends SensitivitySetDefinition> sensitivitySetDefinitions) {
			if (sensitivitySetDefinitions == null) {
				this.sensitivitySetDefinition = new ArrayList<>();
			} else {
				this.sensitivitySetDefinition = sensitivitySetDefinitions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("detail")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("detail")
		@Override
		public ValuationSet.ValuationSetBuilder setDetail(ValuationSetDetail _detail) {
			this.detail = _detail == null ? null : _detail.toBuilder();
			return this;
		}
		
		@RosettaAttribute("assetValuation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("assetValuation")
		@Override
		public ValuationSet.ValuationSetBuilder addAssetValuation(AssetValuation _assetValuation) {
			if (_assetValuation != null) {
				this.assetValuation.add(_assetValuation.toBuilder());
			}
			return this;
		}
		
		@Override
		public ValuationSet.ValuationSetBuilder addAssetValuation(AssetValuation _assetValuation, int idx) {
			getIndex(this.assetValuation, idx, () -> _assetValuation.toBuilder());
			return this;
		}
		
		@Override
		public ValuationSet.ValuationSetBuilder addAssetValuation(List<? extends AssetValuation> assetValuations) {
			if (assetValuations != null) {
				for (final AssetValuation toAdd : assetValuations) {
					this.assetValuation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("assetValuation")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("assetValuation")
		@Override
		public ValuationSet.ValuationSetBuilder setAssetValuation(List<? extends AssetValuation> assetValuations) {
			if (assetValuations == null) {
				this.assetValuation = new ArrayList<>();
			} else {
				this.assetValuation = assetValuations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ValuationSet build() {
			return new ValuationSet.ValuationSetImpl(this);
		}
		
		@Override
		public ValuationSet.ValuationSetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationSet.ValuationSetBuilder prune() {
			valuationScenario = valuationScenario.stream().filter(b->b!=null).<ValuationScenario.ValuationScenarioBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			valuationScenarioReference = valuationScenarioReference.stream().filter(b->b!=null).<ValuationScenarioReference.ValuationScenarioReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (baseParty!=null && !baseParty.prune().hasData()) baseParty = null;
			quotationCharacteristics = quotationCharacteristics.stream().filter(b->b!=null).<QuotationCharacteristics.QuotationCharacteristicsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			sensitivitySetDefinition = sensitivitySetDefinition.stream().filter(b->b!=null).<SensitivitySetDefinition.SensitivitySetDefinitionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (detail!=null && !detail.prune().hasData()) detail = null;
			assetValuation = assetValuation.stream().filter(b->b!=null).<AssetValuation.AssetValuationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getName()!=null) return true;
			if (getValuationScenario()!=null && getValuationScenario().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getValuationScenarioReference()!=null && getValuationScenarioReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBaseParty()!=null && getBaseParty().hasData()) return true;
			if (getQuotationCharacteristics()!=null && getQuotationCharacteristics().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSensitivitySetDefinition()!=null && getSensitivitySetDefinition().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDetail()!=null && getDetail().hasData()) return true;
			if (getAssetValuation()!=null && getAssetValuation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationSet.ValuationSetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ValuationSet.ValuationSetBuilder o = (ValuationSet.ValuationSetBuilder) other;
			
			merger.mergeRosetta(getValuationScenario(), o.getValuationScenario(), this::getOrCreateValuationScenario);
			merger.mergeRosetta(getValuationScenarioReference(), o.getValuationScenarioReference(), this::getOrCreateValuationScenarioReference);
			merger.mergeRosetta(getBaseParty(), o.getBaseParty(), this::setBaseParty);
			merger.mergeRosetta(getQuotationCharacteristics(), o.getQuotationCharacteristics(), this::getOrCreateQuotationCharacteristics);
			merger.mergeRosetta(getSensitivitySetDefinition(), o.getSensitivitySetDefinition(), this::getOrCreateSensitivitySetDefinition);
			merger.mergeRosetta(getDetail(), o.getDetail(), this::setDetail);
			merger.mergeRosetta(getAssetValuation(), o.getAssetValuation(), this::getOrCreateAssetValuation);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getName(), o.getName(), this::setName);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValuationSet _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!ListEquals.listEquals(valuationScenario, _that.getValuationScenario())) return false;
			if (!ListEquals.listEquals(valuationScenarioReference, _that.getValuationScenarioReference())) return false;
			if (!Objects.equals(baseParty, _that.getBaseParty())) return false;
			if (!ListEquals.listEquals(quotationCharacteristics, _that.getQuotationCharacteristics())) return false;
			if (!ListEquals.listEquals(sensitivitySetDefinition, _that.getSensitivitySetDefinition())) return false;
			if (!Objects.equals(detail, _that.getDetail())) return false;
			if (!ListEquals.listEquals(assetValuation, _that.getAssetValuation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (valuationScenario != null ? valuationScenario.hashCode() : 0);
			_result = 31 * _result + (valuationScenarioReference != null ? valuationScenarioReference.hashCode() : 0);
			_result = 31 * _result + (baseParty != null ? baseParty.hashCode() : 0);
			_result = 31 * _result + (quotationCharacteristics != null ? quotationCharacteristics.hashCode() : 0);
			_result = 31 * _result + (sensitivitySetDefinition != null ? sensitivitySetDefinition.hashCode() : 0);
			_result = 31 * _result + (detail != null ? detail.hashCode() : 0);
			_result = 31 * _result + (assetValuation != null ? assetValuation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationSetBuilder {" +
				"id=" + this.id + ", " +
				"name=" + this.name + ", " +
				"valuationScenario=" + this.valuationScenario + ", " +
				"valuationScenarioReference=" + this.valuationScenarioReference + ", " +
				"baseParty=" + this.baseParty + ", " +
				"quotationCharacteristics=" + this.quotationCharacteristics + ", " +
				"sensitivitySetDefinition=" + this.sensitivitySetDefinition + ", " +
				"detail=" + this.detail + ", " +
				"assetValuation=" + this.assetValuation +
			'}';
		}
	}
}
