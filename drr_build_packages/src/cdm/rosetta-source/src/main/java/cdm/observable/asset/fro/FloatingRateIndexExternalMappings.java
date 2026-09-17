package cdm.observable.asset.fro;

import cdm.observable.asset.fro.meta.FloatingRateIndexExternalMappingsMeta;
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
 * Represents the mappings of FRO codes to other.
 * @version 6.23.0
 */
@RosettaDataType(value="FloatingRateIndexExternalMappings", builder=FloatingRateIndexExternalMappings.FloatingRateIndexExternalMappingsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="FloatingRateIndexExternalMappings", model="cdm", builder=FloatingRateIndexExternalMappings.FloatingRateIndexExternalMappingsBuilderImpl.class, version="6.23.0")
public interface FloatingRateIndexExternalMappings extends RosettaModelObject {

	FloatingRateIndexExternalMappingsMeta metaData = new FloatingRateIndexExternalMappingsMeta();

	/*********************** Getter Methods  ***********************/
	FloatingRateIndexExternalMap getIsoCode();

	/*********************** Build Methods  ***********************/
	FloatingRateIndexExternalMappings build();
	
	FloatingRateIndexExternalMappings.FloatingRateIndexExternalMappingsBuilder toBuilder();
	
	static FloatingRateIndexExternalMappings.FloatingRateIndexExternalMappingsBuilder builder() {
		return new FloatingRateIndexExternalMappings.FloatingRateIndexExternalMappingsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRateIndexExternalMappings> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FloatingRateIndexExternalMappings> getType() {
		return FloatingRateIndexExternalMappings.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("isoCode"), processor, FloatingRateIndexExternalMap.class, getIsoCode());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRateIndexExternalMappingsBuilder extends FloatingRateIndexExternalMappings, RosettaModelObjectBuilder {
		FloatingRateIndexExternalMap.FloatingRateIndexExternalMapBuilder getOrCreateIsoCode();
		@Override
		FloatingRateIndexExternalMap.FloatingRateIndexExternalMapBuilder getIsoCode();
		FloatingRateIndexExternalMappings.FloatingRateIndexExternalMappingsBuilder setIsoCode(FloatingRateIndexExternalMap isoCode);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("isoCode"), processor, FloatingRateIndexExternalMap.FloatingRateIndexExternalMapBuilder.class, getIsoCode());
		}
		

		FloatingRateIndexExternalMappings.FloatingRateIndexExternalMappingsBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingRateIndexExternalMappings  ***********************/
	class FloatingRateIndexExternalMappingsImpl implements FloatingRateIndexExternalMappings {
		private final FloatingRateIndexExternalMap isoCode;
		
		protected FloatingRateIndexExternalMappingsImpl(FloatingRateIndexExternalMappings.FloatingRateIndexExternalMappingsBuilder builder) {
			this.isoCode = ofNullable(builder.getIsoCode()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("isoCode")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isoCode")
		public FloatingRateIndexExternalMap getIsoCode() {
			return isoCode;
		}
		
		@Override
		public FloatingRateIndexExternalMappings build() {
			return this;
		}
		
		@Override
		public FloatingRateIndexExternalMappings.FloatingRateIndexExternalMappingsBuilder toBuilder() {
			FloatingRateIndexExternalMappings.FloatingRateIndexExternalMappingsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRateIndexExternalMappings.FloatingRateIndexExternalMappingsBuilder builder) {
			ofNullable(getIsoCode()).ifPresent(builder::setIsoCode);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateIndexExternalMappings _that = getType().cast(o);
		
			if (!Objects.equals(isoCode, _that.getIsoCode())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isoCode != null ? isoCode.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateIndexExternalMappings {" +
				"isoCode=" + this.isoCode +
			'}';
		}
	}

	/*********************** Builder Implementation of FloatingRateIndexExternalMappings  ***********************/
	class FloatingRateIndexExternalMappingsBuilderImpl implements FloatingRateIndexExternalMappings.FloatingRateIndexExternalMappingsBuilder {
	
		protected FloatingRateIndexExternalMap.FloatingRateIndexExternalMapBuilder isoCode;
		
		@Override
		@RosettaAttribute("isoCode")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isoCode")
		public FloatingRateIndexExternalMap.FloatingRateIndexExternalMapBuilder getIsoCode() {
			return isoCode;
		}
		
		@Override
		public FloatingRateIndexExternalMap.FloatingRateIndexExternalMapBuilder getOrCreateIsoCode() {
			FloatingRateIndexExternalMap.FloatingRateIndexExternalMapBuilder result;
			if (isoCode!=null) {
				result = isoCode;
			}
			else {
				result = isoCode = FloatingRateIndexExternalMap.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("isoCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isoCode")
		@Override
		public FloatingRateIndexExternalMappings.FloatingRateIndexExternalMappingsBuilder setIsoCode(FloatingRateIndexExternalMap _isoCode) {
			this.isoCode = _isoCode == null ? null : _isoCode.toBuilder();
			return this;
		}
		
		@Override
		public FloatingRateIndexExternalMappings build() {
			return new FloatingRateIndexExternalMappings.FloatingRateIndexExternalMappingsImpl(this);
		}
		
		@Override
		public FloatingRateIndexExternalMappings.FloatingRateIndexExternalMappingsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateIndexExternalMappings.FloatingRateIndexExternalMappingsBuilder prune() {
			if (isoCode!=null && !isoCode.prune().hasData()) isoCode = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsoCode()!=null && getIsoCode().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateIndexExternalMappings.FloatingRateIndexExternalMappingsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FloatingRateIndexExternalMappings.FloatingRateIndexExternalMappingsBuilder o = (FloatingRateIndexExternalMappings.FloatingRateIndexExternalMappingsBuilder) other;
			
			merger.mergeRosetta(getIsoCode(), o.getIsoCode(), this::setIsoCode);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateIndexExternalMappings _that = getType().cast(o);
		
			if (!Objects.equals(isoCode, _that.getIsoCode())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isoCode != null ? isoCode.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateIndexExternalMappingsBuilder {" +
				"isoCode=" + this.isoCode +
			'}';
		}
	}
}
