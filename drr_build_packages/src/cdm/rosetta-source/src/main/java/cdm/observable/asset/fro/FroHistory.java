package cdm.observable.asset.fro;

import cdm.observable.asset.fro.meta.FroHistoryMeta;
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
import com.rosetta.model.lib.records.Date;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * FRO History
 * @version 6.23.0
 */
@RosettaDataType(value="FroHistory", builder=FroHistory.FroHistoryBuilderImpl.class, version="6.23.0")
@RuneDataType(value="FroHistory", model="cdm", builder=FroHistory.FroHistoryBuilderImpl.class, version="6.23.0")
public interface FroHistory extends RosettaModelObject {

	FroHistoryMeta metaData = new FroHistoryMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The date the Floating Rate Option was added to the 2006 Definitions or 2021 Floating Rate Matrix. (e.g. 2017/04/06)
	 */
	Date getStartDate();
	/**
	 * The supplement or version the FRO was first added to the 2006 Definitions or 2021 Floating Rate Matrix. (e.g. S52)
	 */
	ContractualDefinition getFirstDefinedIn();
	/**
	 * The date the Floating Rate Option was last updated in the 2006 Definitions or 2021 Floating Rate Matrix. (e.g. 2021/06/11)
	 */
	Date getUpdateDate();
	/**
	 * The supplement or version the FRO was last updated in the 2006 Definitions or 2021 Floating Rate Matrix. (e.g. FRO-M-V1)
	 */
	ContractualDefinition getLastUpdatedIn();
	/**
	 * The date the Floating Rate Option was removed from the 2006 Definitions or 2021 Floating Rate Matrix. (e.g. 2014/01/01)
	 */
	Date getEndDate();

	/*********************** Build Methods  ***********************/
	FroHistory build();
	
	FroHistory.FroHistoryBuilder toBuilder();
	
	static FroHistory.FroHistoryBuilder builder() {
		return new FroHistory.FroHistoryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FroHistory> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FroHistory> getType() {
		return FroHistory.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("startDate"), Date.class, getStartDate(), this);
		processRosetta(path.newSubPath("firstDefinedIn"), processor, ContractualDefinition.class, getFirstDefinedIn());
		processor.processBasic(path.newSubPath("updateDate"), Date.class, getUpdateDate(), this);
		processRosetta(path.newSubPath("lastUpdatedIn"), processor, ContractualDefinition.class, getLastUpdatedIn());
		processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FroHistoryBuilder extends FroHistory, RosettaModelObjectBuilder {
		ContractualDefinition.ContractualDefinitionBuilder getOrCreateFirstDefinedIn();
		@Override
		ContractualDefinition.ContractualDefinitionBuilder getFirstDefinedIn();
		ContractualDefinition.ContractualDefinitionBuilder getOrCreateLastUpdatedIn();
		@Override
		ContractualDefinition.ContractualDefinitionBuilder getLastUpdatedIn();
		FroHistory.FroHistoryBuilder setStartDate(Date startDate);
		FroHistory.FroHistoryBuilder setFirstDefinedIn(ContractualDefinition firstDefinedIn);
		FroHistory.FroHistoryBuilder setUpdateDate(Date updateDate);
		FroHistory.FroHistoryBuilder setLastUpdatedIn(ContractualDefinition lastUpdatedIn);
		FroHistory.FroHistoryBuilder setEndDate(Date endDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("startDate"), Date.class, getStartDate(), this);
			processRosetta(path.newSubPath("firstDefinedIn"), processor, ContractualDefinition.ContractualDefinitionBuilder.class, getFirstDefinedIn());
			processor.processBasic(path.newSubPath("updateDate"), Date.class, getUpdateDate(), this);
			processRosetta(path.newSubPath("lastUpdatedIn"), processor, ContractualDefinition.ContractualDefinitionBuilder.class, getLastUpdatedIn());
			processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
		}
		

		FroHistory.FroHistoryBuilder prune();
	}

	/*********************** Immutable Implementation of FroHistory  ***********************/
	class FroHistoryImpl implements FroHistory {
		private final Date startDate;
		private final ContractualDefinition firstDefinedIn;
		private final Date updateDate;
		private final ContractualDefinition lastUpdatedIn;
		private final Date endDate;
		
		protected FroHistoryImpl(FroHistory.FroHistoryBuilder builder) {
			this.startDate = builder.getStartDate();
			this.firstDefinedIn = ofNullable(builder.getFirstDefinedIn()).map(f->f.build()).orElse(null);
			this.updateDate = builder.getUpdateDate();
			this.lastUpdatedIn = ofNullable(builder.getLastUpdatedIn()).map(f->f.build()).orElse(null);
			this.endDate = builder.getEndDate();
		}
		
		@Override
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("startDate")
		public Date getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("firstDefinedIn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("firstDefinedIn")
		public ContractualDefinition getFirstDefinedIn() {
			return firstDefinedIn;
		}
		
		@Override
		@RosettaAttribute("updateDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("updateDate")
		public Date getUpdateDate() {
			return updateDate;
		}
		
		@Override
		@RosettaAttribute("lastUpdatedIn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastUpdatedIn")
		public ContractualDefinition getLastUpdatedIn() {
			return lastUpdatedIn;
		}
		
		@Override
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endDate")
		public Date getEndDate() {
			return endDate;
		}
		
		@Override
		public FroHistory build() {
			return this;
		}
		
		@Override
		public FroHistory.FroHistoryBuilder toBuilder() {
			FroHistory.FroHistoryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FroHistory.FroHistoryBuilder builder) {
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getFirstDefinedIn()).ifPresent(builder::setFirstDefinedIn);
			ofNullable(getUpdateDate()).ifPresent(builder::setUpdateDate);
			ofNullable(getLastUpdatedIn()).ifPresent(builder::setLastUpdatedIn);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FroHistory _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(firstDefinedIn, _that.getFirstDefinedIn())) return false;
			if (!Objects.equals(updateDate, _that.getUpdateDate())) return false;
			if (!Objects.equals(lastUpdatedIn, _that.getLastUpdatedIn())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (firstDefinedIn != null ? firstDefinedIn.hashCode() : 0);
			_result = 31 * _result + (updateDate != null ? updateDate.hashCode() : 0);
			_result = 31 * _result + (lastUpdatedIn != null ? lastUpdatedIn.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FroHistory {" +
				"startDate=" + this.startDate + ", " +
				"firstDefinedIn=" + this.firstDefinedIn + ", " +
				"updateDate=" + this.updateDate + ", " +
				"lastUpdatedIn=" + this.lastUpdatedIn + ", " +
				"endDate=" + this.endDate +
			'}';
		}
	}

	/*********************** Builder Implementation of FroHistory  ***********************/
	class FroHistoryBuilderImpl implements FroHistory.FroHistoryBuilder {
	
		protected Date startDate;
		protected ContractualDefinition.ContractualDefinitionBuilder firstDefinedIn;
		protected Date updateDate;
		protected ContractualDefinition.ContractualDefinitionBuilder lastUpdatedIn;
		protected Date endDate;
		
		@Override
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("startDate")
		public Date getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("firstDefinedIn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("firstDefinedIn")
		public ContractualDefinition.ContractualDefinitionBuilder getFirstDefinedIn() {
			return firstDefinedIn;
		}
		
		@Override
		public ContractualDefinition.ContractualDefinitionBuilder getOrCreateFirstDefinedIn() {
			ContractualDefinition.ContractualDefinitionBuilder result;
			if (firstDefinedIn!=null) {
				result = firstDefinedIn;
			}
			else {
				result = firstDefinedIn = ContractualDefinition.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("updateDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("updateDate")
		public Date getUpdateDate() {
			return updateDate;
		}
		
		@Override
		@RosettaAttribute("lastUpdatedIn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastUpdatedIn")
		public ContractualDefinition.ContractualDefinitionBuilder getLastUpdatedIn() {
			return lastUpdatedIn;
		}
		
		@Override
		public ContractualDefinition.ContractualDefinitionBuilder getOrCreateLastUpdatedIn() {
			ContractualDefinition.ContractualDefinitionBuilder result;
			if (lastUpdatedIn!=null) {
				result = lastUpdatedIn;
			}
			else {
				result = lastUpdatedIn = ContractualDefinition.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endDate")
		public Date getEndDate() {
			return endDate;
		}
		
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("startDate")
		@Override
		public FroHistory.FroHistoryBuilder setStartDate(Date _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("firstDefinedIn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("firstDefinedIn")
		@Override
		public FroHistory.FroHistoryBuilder setFirstDefinedIn(ContractualDefinition _firstDefinedIn) {
			this.firstDefinedIn = _firstDefinedIn == null ? null : _firstDefinedIn.toBuilder();
			return this;
		}
		
		@RosettaAttribute("updateDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("updateDate")
		@Override
		public FroHistory.FroHistoryBuilder setUpdateDate(Date _updateDate) {
			this.updateDate = _updateDate == null ? null : _updateDate;
			return this;
		}
		
		@RosettaAttribute("lastUpdatedIn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastUpdatedIn")
		@Override
		public FroHistory.FroHistoryBuilder setLastUpdatedIn(ContractualDefinition _lastUpdatedIn) {
			this.lastUpdatedIn = _lastUpdatedIn == null ? null : _lastUpdatedIn.toBuilder();
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endDate")
		@Override
		public FroHistory.FroHistoryBuilder setEndDate(Date _endDate) {
			this.endDate = _endDate == null ? null : _endDate;
			return this;
		}
		
		@Override
		public FroHistory build() {
			return new FroHistory.FroHistoryImpl(this);
		}
		
		@Override
		public FroHistory.FroHistoryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FroHistory.FroHistoryBuilder prune() {
			if (firstDefinedIn!=null && !firstDefinedIn.prune().hasData()) firstDefinedIn = null;
			if (lastUpdatedIn!=null && !lastUpdatedIn.prune().hasData()) lastUpdatedIn = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStartDate()!=null) return true;
			if (getFirstDefinedIn()!=null && getFirstDefinedIn().hasData()) return true;
			if (getUpdateDate()!=null) return true;
			if (getLastUpdatedIn()!=null && getLastUpdatedIn().hasData()) return true;
			if (getEndDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FroHistory.FroHistoryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FroHistory.FroHistoryBuilder o = (FroHistory.FroHistoryBuilder) other;
			
			merger.mergeRosetta(getFirstDefinedIn(), o.getFirstDefinedIn(), this::setFirstDefinedIn);
			merger.mergeRosetta(getLastUpdatedIn(), o.getLastUpdatedIn(), this::setLastUpdatedIn);
			
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getUpdateDate(), o.getUpdateDate(), this::setUpdateDate);
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FroHistory _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(firstDefinedIn, _that.getFirstDefinedIn())) return false;
			if (!Objects.equals(updateDate, _that.getUpdateDate())) return false;
			if (!Objects.equals(lastUpdatedIn, _that.getLastUpdatedIn())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (firstDefinedIn != null ? firstDefinedIn.hashCode() : 0);
			_result = 31 * _result + (updateDate != null ? updateDate.hashCode() : 0);
			_result = 31 * _result + (lastUpdatedIn != null ? lastUpdatedIn.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FroHistoryBuilder {" +
				"startDate=" + this.startDate + ", " +
				"firstDefinedIn=" + this.firstDefinedIn + ", " +
				"updateDate=" + this.updateDate + ", " +
				"lastUpdatedIn=" + this.lastUpdatedIn + ", " +
				"endDate=" + this.endDate +
			'}';
		}
	}
}
