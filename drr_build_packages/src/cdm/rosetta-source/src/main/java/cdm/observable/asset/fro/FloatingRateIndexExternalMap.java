package cdm.observable.asset.fro;

import cdm.observable.asset.fro.meta.FloatingRateIndexExternalMapMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A map for a single FRO to or from an equivalent or similar codes in a different standard such as ISO.
 * @version 6.23.0
 */
@RosettaDataType(value="FloatingRateIndexExternalMap", builder=FloatingRateIndexExternalMap.FloatingRateIndexExternalMapBuilderImpl.class, version="6.23.0")
@RuneDataType(value="FloatingRateIndexExternalMap", model="cdm", builder=FloatingRateIndexExternalMap.FloatingRateIndexExternalMapBuilderImpl.class, version="6.23.0")
public interface FloatingRateIndexExternalMap extends RosettaModelObject {

	FloatingRateIndexExternalMapMeta metaData = new FloatingRateIndexExternalMapMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *  The FRO name that is being mapped to/from.
	 */
	String getExternalId();
	/**
	 * The standard/version to which the map applies.
	 */
	String getExternalStandard();

	/*********************** Build Methods  ***********************/
	FloatingRateIndexExternalMap build();
	
	FloatingRateIndexExternalMap.FloatingRateIndexExternalMapBuilder toBuilder();
	
	static FloatingRateIndexExternalMap.FloatingRateIndexExternalMapBuilder builder() {
		return new FloatingRateIndexExternalMap.FloatingRateIndexExternalMapBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRateIndexExternalMap> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FloatingRateIndexExternalMap> getType() {
		return FloatingRateIndexExternalMap.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("externalId"), String.class, getExternalId(), this);
		processor.processBasic(path.newSubPath("externalStandard"), String.class, getExternalStandard(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRateIndexExternalMapBuilder extends FloatingRateIndexExternalMap, RosettaModelObjectBuilder {
		FloatingRateIndexExternalMap.FloatingRateIndexExternalMapBuilder setExternalId(String externalId);
		FloatingRateIndexExternalMap.FloatingRateIndexExternalMapBuilder setExternalStandard(String externalStandard);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("externalId"), String.class, getExternalId(), this);
			processor.processBasic(path.newSubPath("externalStandard"), String.class, getExternalStandard(), this);
		}
		

		FloatingRateIndexExternalMap.FloatingRateIndexExternalMapBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingRateIndexExternalMap  ***********************/
	class FloatingRateIndexExternalMapImpl implements FloatingRateIndexExternalMap {
		private final String externalId;
		private final String externalStandard;
		
		protected FloatingRateIndexExternalMapImpl(FloatingRateIndexExternalMap.FloatingRateIndexExternalMapBuilder builder) {
			this.externalId = builder.getExternalId();
			this.externalStandard = builder.getExternalStandard();
		}
		
		@Override
		@RosettaAttribute("externalId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("externalId")
		public String getExternalId() {
			return externalId;
		}
		
		@Override
		@RosettaAttribute("externalStandard")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("externalStandard")
		public String getExternalStandard() {
			return externalStandard;
		}
		
		@Override
		public FloatingRateIndexExternalMap build() {
			return this;
		}
		
		@Override
		public FloatingRateIndexExternalMap.FloatingRateIndexExternalMapBuilder toBuilder() {
			FloatingRateIndexExternalMap.FloatingRateIndexExternalMapBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRateIndexExternalMap.FloatingRateIndexExternalMapBuilder builder) {
			ofNullable(getExternalId()).ifPresent(builder::setExternalId);
			ofNullable(getExternalStandard()).ifPresent(builder::setExternalStandard);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateIndexExternalMap _that = getType().cast(o);
		
			if (!Objects.equals(externalId, _that.getExternalId())) return false;
			if (!Objects.equals(externalStandard, _that.getExternalStandard())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (externalId != null ? externalId.hashCode() : 0);
			_result = 31 * _result + (externalStandard != null ? externalStandard.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateIndexExternalMap {" +
				"externalId=" + this.externalId + ", " +
				"externalStandard=" + this.externalStandard +
			'}';
		}
	}

	/*********************** Builder Implementation of FloatingRateIndexExternalMap  ***********************/
	class FloatingRateIndexExternalMapBuilderImpl implements FloatingRateIndexExternalMap.FloatingRateIndexExternalMapBuilder {
	
		protected String externalId;
		protected String externalStandard;
		
		@Override
		@RosettaAttribute("externalId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("externalId")
		public String getExternalId() {
			return externalId;
		}
		
		@Override
		@RosettaAttribute("externalStandard")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("externalStandard")
		public String getExternalStandard() {
			return externalStandard;
		}
		
		@RosettaAttribute("externalId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("externalId")
		@Override
		public FloatingRateIndexExternalMap.FloatingRateIndexExternalMapBuilder setExternalId(String _externalId) {
			this.externalId = _externalId == null ? null : _externalId;
			return this;
		}
		
		@RosettaAttribute("externalStandard")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("externalStandard")
		@Override
		public FloatingRateIndexExternalMap.FloatingRateIndexExternalMapBuilder setExternalStandard(String _externalStandard) {
			this.externalStandard = _externalStandard == null ? null : _externalStandard;
			return this;
		}
		
		@Override
		public FloatingRateIndexExternalMap build() {
			return new FloatingRateIndexExternalMap.FloatingRateIndexExternalMapImpl(this);
		}
		
		@Override
		public FloatingRateIndexExternalMap.FloatingRateIndexExternalMapBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateIndexExternalMap.FloatingRateIndexExternalMapBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExternalId()!=null) return true;
			if (getExternalStandard()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateIndexExternalMap.FloatingRateIndexExternalMapBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FloatingRateIndexExternalMap.FloatingRateIndexExternalMapBuilder o = (FloatingRateIndexExternalMap.FloatingRateIndexExternalMapBuilder) other;
			
			
			merger.mergeBasic(getExternalId(), o.getExternalId(), this::setExternalId);
			merger.mergeBasic(getExternalStandard(), o.getExternalStandard(), this::setExternalStandard);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateIndexExternalMap _that = getType().cast(o);
		
			if (!Objects.equals(externalId, _that.getExternalId())) return false;
			if (!Objects.equals(externalStandard, _that.getExternalStandard())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (externalId != null ? externalId.hashCode() : 0);
			_result = 31 * _result + (externalStandard != null ? externalStandard.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateIndexExternalMapBuilder {" +
				"externalId=" + this.externalId + ", " +
				"externalStandard=" + this.externalStandard +
			'}';
		}
	}
}
