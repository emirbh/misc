package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.CollateralTransferTimingMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specification of transfer / settlement timing for cash and securities collateral assuming that the notice is provided before the Notification Time (and with a 1LBD lag introduced if the notice is delivered after the Notification Time), and that securities allow for a further Local Business Day for transfer / settlement.
 * @version 6.23.0
 */
@RosettaDataType(value="CollateralTransferTiming", builder=CollateralTransferTiming.CollateralTransferTimingBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CollateralTransferTiming", model="cdm", builder=CollateralTransferTiming.CollateralTransferTimingBuilderImpl.class, version="6.23.0")
public interface CollateralTransferTiming extends RosettaModelObject {

	CollateralTransferTimingMeta metaData = new CollateralTransferTimingMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specification of transfer / settlement timing for cash and securities collateral assuming that the notice is provided before the Notification Time (and with a 1LBD lag introduced if the notice is delivered after the Notification Time), and that securities allow for a further Local Business Day for transfer / settlement.
	 */
	LegacyTransferSettlementTiming getTransferSettlementTiming();
	/**
	 * Bespoke language removing the pre-print requirement to transfer legal title of securities collateral through written instructions to the relevant depository institution or other securities intermediaries solely for the purposes of the 1994 New York Law Credit Support Annex.
	 */
	LegacyDefinition getLegacyDefinition();

	/*********************** Build Methods  ***********************/
	CollateralTransferTiming build();
	
	CollateralTransferTiming.CollateralTransferTimingBuilder toBuilder();
	
	static CollateralTransferTiming.CollateralTransferTimingBuilder builder() {
		return new CollateralTransferTiming.CollateralTransferTimingBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralTransferTiming> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CollateralTransferTiming> getType() {
		return CollateralTransferTiming.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("transferSettlementTiming"), processor, LegacyTransferSettlementTiming.class, getTransferSettlementTiming());
		processRosetta(path.newSubPath("legacyDefinition"), processor, LegacyDefinition.class, getLegacyDefinition());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralTransferTimingBuilder extends CollateralTransferTiming, RosettaModelObjectBuilder {
		LegacyTransferSettlementTiming.LegacyTransferSettlementTimingBuilder getOrCreateTransferSettlementTiming();
		@Override
		LegacyTransferSettlementTiming.LegacyTransferSettlementTimingBuilder getTransferSettlementTiming();
		LegacyDefinition.LegacyDefinitionBuilder getOrCreateLegacyDefinition();
		@Override
		LegacyDefinition.LegacyDefinitionBuilder getLegacyDefinition();
		CollateralTransferTiming.CollateralTransferTimingBuilder setTransferSettlementTiming(LegacyTransferSettlementTiming transferSettlementTiming);
		CollateralTransferTiming.CollateralTransferTimingBuilder setLegacyDefinition(LegacyDefinition legacyDefinition);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("transferSettlementTiming"), processor, LegacyTransferSettlementTiming.LegacyTransferSettlementTimingBuilder.class, getTransferSettlementTiming());
			processRosetta(path.newSubPath("legacyDefinition"), processor, LegacyDefinition.LegacyDefinitionBuilder.class, getLegacyDefinition());
		}
		

		CollateralTransferTiming.CollateralTransferTimingBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralTransferTiming  ***********************/
	class CollateralTransferTimingImpl implements CollateralTransferTiming {
		private final LegacyTransferSettlementTiming transferSettlementTiming;
		private final LegacyDefinition legacyDefinition;
		
		protected CollateralTransferTimingImpl(CollateralTransferTiming.CollateralTransferTimingBuilder builder) {
			this.transferSettlementTiming = ofNullable(builder.getTransferSettlementTiming()).map(f->f.build()).orElse(null);
			this.legacyDefinition = ofNullable(builder.getLegacyDefinition()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("transferSettlementTiming")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transferSettlementTiming")
		public LegacyTransferSettlementTiming getTransferSettlementTiming() {
			return transferSettlementTiming;
		}
		
		@Override
		@RosettaAttribute("legacyDefinition")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legacyDefinition")
		public LegacyDefinition getLegacyDefinition() {
			return legacyDefinition;
		}
		
		@Override
		public CollateralTransferTiming build() {
			return this;
		}
		
		@Override
		public CollateralTransferTiming.CollateralTransferTimingBuilder toBuilder() {
			CollateralTransferTiming.CollateralTransferTimingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralTransferTiming.CollateralTransferTimingBuilder builder) {
			ofNullable(getTransferSettlementTiming()).ifPresent(builder::setTransferSettlementTiming);
			ofNullable(getLegacyDefinition()).ifPresent(builder::setLegacyDefinition);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralTransferTiming _that = getType().cast(o);
		
			if (!Objects.equals(transferSettlementTiming, _that.getTransferSettlementTiming())) return false;
			if (!Objects.equals(legacyDefinition, _that.getLegacyDefinition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (transferSettlementTiming != null ? transferSettlementTiming.hashCode() : 0);
			_result = 31 * _result + (legacyDefinition != null ? legacyDefinition.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralTransferTiming {" +
				"transferSettlementTiming=" + this.transferSettlementTiming + ", " +
				"legacyDefinition=" + this.legacyDefinition +
			'}';
		}
	}

	/*********************** Builder Implementation of CollateralTransferTiming  ***********************/
	class CollateralTransferTimingBuilderImpl implements CollateralTransferTiming.CollateralTransferTimingBuilder {
	
		protected LegacyTransferSettlementTiming.LegacyTransferSettlementTimingBuilder transferSettlementTiming;
		protected LegacyDefinition.LegacyDefinitionBuilder legacyDefinition;
		
		@Override
		@RosettaAttribute("transferSettlementTiming")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transferSettlementTiming")
		public LegacyTransferSettlementTiming.LegacyTransferSettlementTimingBuilder getTransferSettlementTiming() {
			return transferSettlementTiming;
		}
		
		@Override
		public LegacyTransferSettlementTiming.LegacyTransferSettlementTimingBuilder getOrCreateTransferSettlementTiming() {
			LegacyTransferSettlementTiming.LegacyTransferSettlementTimingBuilder result;
			if (transferSettlementTiming!=null) {
				result = transferSettlementTiming;
			}
			else {
				result = transferSettlementTiming = LegacyTransferSettlementTiming.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("legacyDefinition")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legacyDefinition")
		public LegacyDefinition.LegacyDefinitionBuilder getLegacyDefinition() {
			return legacyDefinition;
		}
		
		@Override
		public LegacyDefinition.LegacyDefinitionBuilder getOrCreateLegacyDefinition() {
			LegacyDefinition.LegacyDefinitionBuilder result;
			if (legacyDefinition!=null) {
				result = legacyDefinition;
			}
			else {
				result = legacyDefinition = LegacyDefinition.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("transferSettlementTiming")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("transferSettlementTiming")
		@Override
		public CollateralTransferTiming.CollateralTransferTimingBuilder setTransferSettlementTiming(LegacyTransferSettlementTiming _transferSettlementTiming) {
			this.transferSettlementTiming = _transferSettlementTiming == null ? null : _transferSettlementTiming.toBuilder();
			return this;
		}
		
		@RosettaAttribute("legacyDefinition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legacyDefinition")
		@Override
		public CollateralTransferTiming.CollateralTransferTimingBuilder setLegacyDefinition(LegacyDefinition _legacyDefinition) {
			this.legacyDefinition = _legacyDefinition == null ? null : _legacyDefinition.toBuilder();
			return this;
		}
		
		@Override
		public CollateralTransferTiming build() {
			return new CollateralTransferTiming.CollateralTransferTimingImpl(this);
		}
		
		@Override
		public CollateralTransferTiming.CollateralTransferTimingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralTransferTiming.CollateralTransferTimingBuilder prune() {
			if (transferSettlementTiming!=null && !transferSettlementTiming.prune().hasData()) transferSettlementTiming = null;
			if (legacyDefinition!=null && !legacyDefinition.prune().hasData()) legacyDefinition = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTransferSettlementTiming()!=null && getTransferSettlementTiming().hasData()) return true;
			if (getLegacyDefinition()!=null && getLegacyDefinition().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralTransferTiming.CollateralTransferTimingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralTransferTiming.CollateralTransferTimingBuilder o = (CollateralTransferTiming.CollateralTransferTimingBuilder) other;
			
			merger.mergeRosetta(getTransferSettlementTiming(), o.getTransferSettlementTiming(), this::setTransferSettlementTiming);
			merger.mergeRosetta(getLegacyDefinition(), o.getLegacyDefinition(), this::setLegacyDefinition);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralTransferTiming _that = getType().cast(o);
		
			if (!Objects.equals(transferSettlementTiming, _that.getTransferSettlementTiming())) return false;
			if (!Objects.equals(legacyDefinition, _that.getLegacyDefinition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (transferSettlementTiming != null ? transferSettlementTiming.hashCode() : 0);
			_result = 31 * _result + (legacyDefinition != null ? legacyDefinition.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralTransferTimingBuilder {" +
				"transferSettlementTiming=" + this.transferSettlementTiming + ", " +
				"legacyDefinition=" + this.legacyDefinition +
			'}';
		}
	}
}
