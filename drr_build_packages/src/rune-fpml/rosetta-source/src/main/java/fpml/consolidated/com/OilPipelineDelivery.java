package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.OilPipelineDeliveryMeta;
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
 * Provision The physical delivery conditions specific to an oil product delivered by pipeline.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The physical delivery conditions specific to an oil product delivered by pipeline.
 *
 */
@RosettaDataType(value="OilPipelineDelivery", builder=OilPipelineDelivery.OilPipelineDeliveryBuilderImpl.class, version="2.1.1")
@RuneDataType(value="OilPipelineDelivery", model="fpml", builder=OilPipelineDelivery.OilPipelineDeliveryBuilderImpl.class, version="2.1.1")
public interface OilPipelineDelivery extends RosettaModelObject {

	OilPipelineDeliveryMeta metaData = new OilPipelineDeliveryMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The name of pipeline by which the oil product will be delivered.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The name of pipeline by which the oil product will be delivered.
	 *
	 */
	CommodityPipeline getPipelineName();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The location at which the transfer of the title to the commodity takes place.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The location at which the transfer of the title to the commodity takes place.
	 *
	 */
	CommodityDeliveryPoint getWithdrawalPoint();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The point at which the oil product will enter the pipeline.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The point at which the oil product will enter the pipeline.
	 *
	 */
	CommodityDeliveryPoint getEntryPoint();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Whether or not the delivery can go to barge. For trades documented under the ISDA Master Agreement and Oil Annex, this should always be set to 'false'.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Whether or not the delivery can go to barge. For trades documented under the ISDA Master Agreement and Oil Annex, this should always be set to 'false'.
	 *
	 */
	Boolean getDeliverableByBarge();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies how the risk associated with the delivery is assigned. For trades documented under the ISDA Master Agreement and Oil Annex, this presence of this element indicates that the provisions of clause (b)(i) of the ISDA Oil Annex are being varied.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies how the risk associated with the delivery is assigned. For trades documented under the ISDA Master Agreement and Oil Annex, this presence of this element indicates that the provisions of clause (b)(i) of the ISDA Oil Annex are being varied.
	 *
	 */
	CommodityDeliveryRisk getRisk();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The cycle(s) during which the oil product will be transported in the pipeline.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The cycle(s) during which the oil product will be transported in the pipeline.
	 *
	 */
	List<? extends CommodityPipelineCycle> getCycle();

	/*********************** Build Methods  ***********************/
	OilPipelineDelivery build();
	
	OilPipelineDelivery.OilPipelineDeliveryBuilder toBuilder();
	
	static OilPipelineDelivery.OilPipelineDeliveryBuilder builder() {
		return new OilPipelineDelivery.OilPipelineDeliveryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OilPipelineDelivery> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OilPipelineDelivery> getType() {
		return OilPipelineDelivery.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("pipelineName"), processor, CommodityPipeline.class, getPipelineName());
		processRosetta(path.newSubPath("withdrawalPoint"), processor, CommodityDeliveryPoint.class, getWithdrawalPoint());
		processRosetta(path.newSubPath("entryPoint"), processor, CommodityDeliveryPoint.class, getEntryPoint());
		processor.processBasic(path.newSubPath("deliverableByBarge"), Boolean.class, getDeliverableByBarge(), this);
		processRosetta(path.newSubPath("risk"), processor, CommodityDeliveryRisk.class, getRisk());
		processRosetta(path.newSubPath("cycle"), processor, CommodityPipelineCycle.class, getCycle());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OilPipelineDeliveryBuilder extends OilPipelineDelivery, RosettaModelObjectBuilder {
		CommodityPipeline.CommodityPipelineBuilder getOrCreatePipelineName();
		@Override
		CommodityPipeline.CommodityPipelineBuilder getPipelineName();
		CommodityDeliveryPoint.CommodityDeliveryPointBuilder getOrCreateWithdrawalPoint();
		@Override
		CommodityDeliveryPoint.CommodityDeliveryPointBuilder getWithdrawalPoint();
		CommodityDeliveryPoint.CommodityDeliveryPointBuilder getOrCreateEntryPoint();
		@Override
		CommodityDeliveryPoint.CommodityDeliveryPointBuilder getEntryPoint();
		CommodityDeliveryRisk.CommodityDeliveryRiskBuilder getOrCreateRisk();
		@Override
		CommodityDeliveryRisk.CommodityDeliveryRiskBuilder getRisk();
		CommodityPipelineCycle.CommodityPipelineCycleBuilder getOrCreateCycle(int index);
		@Override
		List<? extends CommodityPipelineCycle.CommodityPipelineCycleBuilder> getCycle();
		OilPipelineDelivery.OilPipelineDeliveryBuilder setPipelineName(CommodityPipeline pipelineName);
		OilPipelineDelivery.OilPipelineDeliveryBuilder setWithdrawalPoint(CommodityDeliveryPoint withdrawalPoint);
		OilPipelineDelivery.OilPipelineDeliveryBuilder setEntryPoint(CommodityDeliveryPoint entryPoint);
		OilPipelineDelivery.OilPipelineDeliveryBuilder setDeliverableByBarge(Boolean deliverableByBarge);
		OilPipelineDelivery.OilPipelineDeliveryBuilder setRisk(CommodityDeliveryRisk risk);
		OilPipelineDelivery.OilPipelineDeliveryBuilder addCycle(CommodityPipelineCycle cycle);
		OilPipelineDelivery.OilPipelineDeliveryBuilder addCycle(CommodityPipelineCycle cycle, int idx);
		OilPipelineDelivery.OilPipelineDeliveryBuilder addCycle(List<? extends CommodityPipelineCycle> cycle);
		OilPipelineDelivery.OilPipelineDeliveryBuilder setCycle(List<? extends CommodityPipelineCycle> cycle);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("pipelineName"), processor, CommodityPipeline.CommodityPipelineBuilder.class, getPipelineName());
			processRosetta(path.newSubPath("withdrawalPoint"), processor, CommodityDeliveryPoint.CommodityDeliveryPointBuilder.class, getWithdrawalPoint());
			processRosetta(path.newSubPath("entryPoint"), processor, CommodityDeliveryPoint.CommodityDeliveryPointBuilder.class, getEntryPoint());
			processor.processBasic(path.newSubPath("deliverableByBarge"), Boolean.class, getDeliverableByBarge(), this);
			processRosetta(path.newSubPath("risk"), processor, CommodityDeliveryRisk.CommodityDeliveryRiskBuilder.class, getRisk());
			processRosetta(path.newSubPath("cycle"), processor, CommodityPipelineCycle.CommodityPipelineCycleBuilder.class, getCycle());
		}
		

		OilPipelineDelivery.OilPipelineDeliveryBuilder prune();
	}

	/*********************** Immutable Implementation of OilPipelineDelivery  ***********************/
	class OilPipelineDeliveryImpl implements OilPipelineDelivery {
		private final CommodityPipeline pipelineName;
		private final CommodityDeliveryPoint withdrawalPoint;
		private final CommodityDeliveryPoint entryPoint;
		private final Boolean deliverableByBarge;
		private final CommodityDeliveryRisk risk;
		private final List<? extends CommodityPipelineCycle> cycle;
		
		protected OilPipelineDeliveryImpl(OilPipelineDelivery.OilPipelineDeliveryBuilder builder) {
			this.pipelineName = ofNullable(builder.getPipelineName()).map(f->f.build()).orElse(null);
			this.withdrawalPoint = ofNullable(builder.getWithdrawalPoint()).map(f->f.build()).orElse(null);
			this.entryPoint = ofNullable(builder.getEntryPoint()).map(f->f.build()).orElse(null);
			this.deliverableByBarge = builder.getDeliverableByBarge();
			this.risk = ofNullable(builder.getRisk()).map(f->f.build()).orElse(null);
			this.cycle = ofNullable(builder.getCycle()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("pipelineName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pipelineName")
		public CommodityPipeline getPipelineName() {
			return pipelineName;
		}
		
		@Override
		@RosettaAttribute("withdrawalPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("withdrawalPoint")
		public CommodityDeliveryPoint getWithdrawalPoint() {
			return withdrawalPoint;
		}
		
		@Override
		@RosettaAttribute("entryPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("entryPoint")
		public CommodityDeliveryPoint getEntryPoint() {
			return entryPoint;
		}
		
		@Override
		@RosettaAttribute("deliverableByBarge")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliverableByBarge")
		public Boolean getDeliverableByBarge() {
			return deliverableByBarge;
		}
		
		@Override
		@RosettaAttribute("risk")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("risk")
		public CommodityDeliveryRisk getRisk() {
			return risk;
		}
		
		@Override
		@RosettaAttribute("cycle")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cycle")
		public List<? extends CommodityPipelineCycle> getCycle() {
			return cycle;
		}
		
		@Override
		public OilPipelineDelivery build() {
			return this;
		}
		
		@Override
		public OilPipelineDelivery.OilPipelineDeliveryBuilder toBuilder() {
			OilPipelineDelivery.OilPipelineDeliveryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OilPipelineDelivery.OilPipelineDeliveryBuilder builder) {
			ofNullable(getPipelineName()).ifPresent(builder::setPipelineName);
			ofNullable(getWithdrawalPoint()).ifPresent(builder::setWithdrawalPoint);
			ofNullable(getEntryPoint()).ifPresent(builder::setEntryPoint);
			ofNullable(getDeliverableByBarge()).ifPresent(builder::setDeliverableByBarge);
			ofNullable(getRisk()).ifPresent(builder::setRisk);
			ofNullable(getCycle()).ifPresent(builder::setCycle);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OilPipelineDelivery _that = getType().cast(o);
		
			if (!Objects.equals(pipelineName, _that.getPipelineName())) return false;
			if (!Objects.equals(withdrawalPoint, _that.getWithdrawalPoint())) return false;
			if (!Objects.equals(entryPoint, _that.getEntryPoint())) return false;
			if (!Objects.equals(deliverableByBarge, _that.getDeliverableByBarge())) return false;
			if (!Objects.equals(risk, _that.getRisk())) return false;
			if (!ListEquals.listEquals(cycle, _that.getCycle())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pipelineName != null ? pipelineName.hashCode() : 0);
			_result = 31 * _result + (withdrawalPoint != null ? withdrawalPoint.hashCode() : 0);
			_result = 31 * _result + (entryPoint != null ? entryPoint.hashCode() : 0);
			_result = 31 * _result + (deliverableByBarge != null ? deliverableByBarge.hashCode() : 0);
			_result = 31 * _result + (risk != null ? risk.hashCode() : 0);
			_result = 31 * _result + (cycle != null ? cycle.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OilPipelineDelivery {" +
				"pipelineName=" + this.pipelineName + ", " +
				"withdrawalPoint=" + this.withdrawalPoint + ", " +
				"entryPoint=" + this.entryPoint + ", " +
				"deliverableByBarge=" + this.deliverableByBarge + ", " +
				"risk=" + this.risk + ", " +
				"cycle=" + this.cycle +
			'}';
		}
	}

	/*********************** Builder Implementation of OilPipelineDelivery  ***********************/
	class OilPipelineDeliveryBuilderImpl implements OilPipelineDelivery.OilPipelineDeliveryBuilder {
	
		protected CommodityPipeline.CommodityPipelineBuilder pipelineName;
		protected CommodityDeliveryPoint.CommodityDeliveryPointBuilder withdrawalPoint;
		protected CommodityDeliveryPoint.CommodityDeliveryPointBuilder entryPoint;
		protected Boolean deliverableByBarge;
		protected CommodityDeliveryRisk.CommodityDeliveryRiskBuilder risk;
		protected List<CommodityPipelineCycle.CommodityPipelineCycleBuilder> cycle = new ArrayList<>();
		
		@Override
		@RosettaAttribute("pipelineName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pipelineName")
		public CommodityPipeline.CommodityPipelineBuilder getPipelineName() {
			return pipelineName;
		}
		
		@Override
		public CommodityPipeline.CommodityPipelineBuilder getOrCreatePipelineName() {
			CommodityPipeline.CommodityPipelineBuilder result;
			if (pipelineName!=null) {
				result = pipelineName;
			}
			else {
				result = pipelineName = CommodityPipeline.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("withdrawalPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("withdrawalPoint")
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder getWithdrawalPoint() {
			return withdrawalPoint;
		}
		
		@Override
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder getOrCreateWithdrawalPoint() {
			CommodityDeliveryPoint.CommodityDeliveryPointBuilder result;
			if (withdrawalPoint!=null) {
				result = withdrawalPoint;
			}
			else {
				result = withdrawalPoint = CommodityDeliveryPoint.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("entryPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("entryPoint")
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder getEntryPoint() {
			return entryPoint;
		}
		
		@Override
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder getOrCreateEntryPoint() {
			CommodityDeliveryPoint.CommodityDeliveryPointBuilder result;
			if (entryPoint!=null) {
				result = entryPoint;
			}
			else {
				result = entryPoint = CommodityDeliveryPoint.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliverableByBarge")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliverableByBarge")
		public Boolean getDeliverableByBarge() {
			return deliverableByBarge;
		}
		
		@Override
		@RosettaAttribute("risk")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("risk")
		public CommodityDeliveryRisk.CommodityDeliveryRiskBuilder getRisk() {
			return risk;
		}
		
		@Override
		public CommodityDeliveryRisk.CommodityDeliveryRiskBuilder getOrCreateRisk() {
			CommodityDeliveryRisk.CommodityDeliveryRiskBuilder result;
			if (risk!=null) {
				result = risk;
			}
			else {
				result = risk = CommodityDeliveryRisk.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cycle")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cycle")
		public List<? extends CommodityPipelineCycle.CommodityPipelineCycleBuilder> getCycle() {
			return cycle;
		}
		
		@Override
		public CommodityPipelineCycle.CommodityPipelineCycleBuilder getOrCreateCycle(int index) {
			if (cycle==null) {
				this.cycle = new ArrayList<>();
			}
			return getIndex(cycle, index, () -> {
						CommodityPipelineCycle.CommodityPipelineCycleBuilder newCycle = CommodityPipelineCycle.builder();
						return newCycle;
					});
		}
		
		@RosettaAttribute("pipelineName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pipelineName")
		@Override
		public OilPipelineDelivery.OilPipelineDeliveryBuilder setPipelineName(CommodityPipeline _pipelineName) {
			this.pipelineName = _pipelineName == null ? null : _pipelineName.toBuilder();
			return this;
		}
		
		@RosettaAttribute("withdrawalPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("withdrawalPoint")
		@Override
		public OilPipelineDelivery.OilPipelineDeliveryBuilder setWithdrawalPoint(CommodityDeliveryPoint _withdrawalPoint) {
			this.withdrawalPoint = _withdrawalPoint == null ? null : _withdrawalPoint.toBuilder();
			return this;
		}
		
		@RosettaAttribute("entryPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("entryPoint")
		@Override
		public OilPipelineDelivery.OilPipelineDeliveryBuilder setEntryPoint(CommodityDeliveryPoint _entryPoint) {
			this.entryPoint = _entryPoint == null ? null : _entryPoint.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliverableByBarge")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliverableByBarge")
		@Override
		public OilPipelineDelivery.OilPipelineDeliveryBuilder setDeliverableByBarge(Boolean _deliverableByBarge) {
			this.deliverableByBarge = _deliverableByBarge == null ? null : _deliverableByBarge;
			return this;
		}
		
		@RosettaAttribute("risk")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("risk")
		@Override
		public OilPipelineDelivery.OilPipelineDeliveryBuilder setRisk(CommodityDeliveryRisk _risk) {
			this.risk = _risk == null ? null : _risk.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cycle")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("cycle")
		@Override
		public OilPipelineDelivery.OilPipelineDeliveryBuilder addCycle(CommodityPipelineCycle _cycle) {
			if (_cycle != null) {
				this.cycle.add(_cycle.toBuilder());
			}
			return this;
		}
		
		@Override
		public OilPipelineDelivery.OilPipelineDeliveryBuilder addCycle(CommodityPipelineCycle _cycle, int idx) {
			getIndex(this.cycle, idx, () -> _cycle.toBuilder());
			return this;
		}
		
		@Override
		public OilPipelineDelivery.OilPipelineDeliveryBuilder addCycle(List<? extends CommodityPipelineCycle> cycles) {
			if (cycles != null) {
				for (final CommodityPipelineCycle toAdd : cycles) {
					this.cycle.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("cycle")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("cycle")
		@Override
		public OilPipelineDelivery.OilPipelineDeliveryBuilder setCycle(List<? extends CommodityPipelineCycle> cycles) {
			if (cycles == null) {
				this.cycle = new ArrayList<>();
			} else {
				this.cycle = cycles.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public OilPipelineDelivery build() {
			return new OilPipelineDelivery.OilPipelineDeliveryImpl(this);
		}
		
		@Override
		public OilPipelineDelivery.OilPipelineDeliveryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OilPipelineDelivery.OilPipelineDeliveryBuilder prune() {
			if (pipelineName!=null && !pipelineName.prune().hasData()) pipelineName = null;
			if (withdrawalPoint!=null && !withdrawalPoint.prune().hasData()) withdrawalPoint = null;
			if (entryPoint!=null && !entryPoint.prune().hasData()) entryPoint = null;
			if (risk!=null && !risk.prune().hasData()) risk = null;
			cycle = cycle.stream().filter(b->b!=null).<CommodityPipelineCycle.CommodityPipelineCycleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPipelineName()!=null && getPipelineName().hasData()) return true;
			if (getWithdrawalPoint()!=null && getWithdrawalPoint().hasData()) return true;
			if (getEntryPoint()!=null && getEntryPoint().hasData()) return true;
			if (getDeliverableByBarge()!=null) return true;
			if (getRisk()!=null && getRisk().hasData()) return true;
			if (getCycle()!=null && getCycle().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OilPipelineDelivery.OilPipelineDeliveryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OilPipelineDelivery.OilPipelineDeliveryBuilder o = (OilPipelineDelivery.OilPipelineDeliveryBuilder) other;
			
			merger.mergeRosetta(getPipelineName(), o.getPipelineName(), this::setPipelineName);
			merger.mergeRosetta(getWithdrawalPoint(), o.getWithdrawalPoint(), this::setWithdrawalPoint);
			merger.mergeRosetta(getEntryPoint(), o.getEntryPoint(), this::setEntryPoint);
			merger.mergeRosetta(getRisk(), o.getRisk(), this::setRisk);
			merger.mergeRosetta(getCycle(), o.getCycle(), this::getOrCreateCycle);
			
			merger.mergeBasic(getDeliverableByBarge(), o.getDeliverableByBarge(), this::setDeliverableByBarge);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OilPipelineDelivery _that = getType().cast(o);
		
			if (!Objects.equals(pipelineName, _that.getPipelineName())) return false;
			if (!Objects.equals(withdrawalPoint, _that.getWithdrawalPoint())) return false;
			if (!Objects.equals(entryPoint, _that.getEntryPoint())) return false;
			if (!Objects.equals(deliverableByBarge, _that.getDeliverableByBarge())) return false;
			if (!Objects.equals(risk, _that.getRisk())) return false;
			if (!ListEquals.listEquals(cycle, _that.getCycle())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pipelineName != null ? pipelineName.hashCode() : 0);
			_result = 31 * _result + (withdrawalPoint != null ? withdrawalPoint.hashCode() : 0);
			_result = 31 * _result + (entryPoint != null ? entryPoint.hashCode() : 0);
			_result = 31 * _result + (deliverableByBarge != null ? deliverableByBarge.hashCode() : 0);
			_result = 31 * _result + (risk != null ? risk.hashCode() : 0);
			_result = 31 * _result + (cycle != null ? cycle.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OilPipelineDeliveryBuilder {" +
				"pipelineName=" + this.pipelineName + ", " +
				"withdrawalPoint=" + this.withdrawalPoint + ", " +
				"entryPoint=" + this.entryPoint + ", " +
				"deliverableByBarge=" + this.deliverableByBarge + ", " +
				"risk=" + this.risk + ", " +
				"cycle=" + this.cycle +
			'}';
		}
	}
}
