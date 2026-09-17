package fpml.consolidated.business.events;

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
import fpml.consolidated.business.events.meta.ObservationSourceMeta;
import fpml.consolidated.generic.TradeUnderlyer2;
import fpml.consolidated.shared.InformationSource;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The observation source can be composed of an curve and/or and information source.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The observation source can be composed of an curve and/or and information source.
 *
 */
@RosettaDataType(value="ObservationSource", builder=ObservationSource.ObservationSourceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ObservationSource", model="fpml", builder=ObservationSource.ObservationSourceBuilderImpl.class, version="2.1.1")
public interface ObservationSource extends RosettaModelObject {

	ObservationSourceMeta metaData = new ObservationSourceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The source of the observation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The source of the observation.
	 *
	 */
	InformationSource getInformationSource();
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
	TradeUnderlyer2 getUnderlyer();

	/*********************** Build Methods  ***********************/
	ObservationSource build();
	
	ObservationSource.ObservationSourceBuilder toBuilder();
	
	static ObservationSource.ObservationSourceBuilder builder() {
		return new ObservationSource.ObservationSourceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ObservationSource> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ObservationSource> getType() {
		return ObservationSource.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("informationSource"), processor, InformationSource.class, getInformationSource());
		processRosetta(path.newSubPath("underlyer"), processor, TradeUnderlyer2.class, getUnderlyer());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ObservationSourceBuilder extends ObservationSource, RosettaModelObjectBuilder {
		InformationSource.InformationSourceBuilder getOrCreateInformationSource();
		@Override
		InformationSource.InformationSourceBuilder getInformationSource();
		TradeUnderlyer2.TradeUnderlyer2Builder getOrCreateUnderlyer();
		@Override
		TradeUnderlyer2.TradeUnderlyer2Builder getUnderlyer();
		ObservationSource.ObservationSourceBuilder setInformationSource(InformationSource informationSource);
		ObservationSource.ObservationSourceBuilder setUnderlyer(TradeUnderlyer2 underlyer);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("informationSource"), processor, InformationSource.InformationSourceBuilder.class, getInformationSource());
			processRosetta(path.newSubPath("underlyer"), processor, TradeUnderlyer2.TradeUnderlyer2Builder.class, getUnderlyer());
		}
		

		ObservationSource.ObservationSourceBuilder prune();
	}

	/*********************** Immutable Implementation of ObservationSource  ***********************/
	class ObservationSourceImpl implements ObservationSource {
		private final InformationSource informationSource;
		private final TradeUnderlyer2 underlyer;
		
		protected ObservationSourceImpl(ObservationSource.ObservationSourceBuilder builder) {
			this.informationSource = ofNullable(builder.getInformationSource()).map(f->f.build()).orElse(null);
			this.underlyer = ofNullable(builder.getUnderlyer()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("informationSource")
		public InformationSource getInformationSource() {
			return informationSource;
		}
		
		@Override
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyer")
		public TradeUnderlyer2 getUnderlyer() {
			return underlyer;
		}
		
		@Override
		public ObservationSource build() {
			return this;
		}
		
		@Override
		public ObservationSource.ObservationSourceBuilder toBuilder() {
			ObservationSource.ObservationSourceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ObservationSource.ObservationSourceBuilder builder) {
			ofNullable(getInformationSource()).ifPresent(builder::setInformationSource);
			ofNullable(getUnderlyer()).ifPresent(builder::setUnderlyer);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObservationSource _that = getType().cast(o);
		
			if (!Objects.equals(informationSource, _that.getInformationSource())) return false;
			if (!Objects.equals(underlyer, _that.getUnderlyer())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservationSource {" +
				"informationSource=" + this.informationSource + ", " +
				"underlyer=" + this.underlyer +
			'}';
		}
	}

	/*********************** Builder Implementation of ObservationSource  ***********************/
	class ObservationSourceBuilderImpl implements ObservationSource.ObservationSourceBuilder {
	
		protected InformationSource.InformationSourceBuilder informationSource;
		protected TradeUnderlyer2.TradeUnderlyer2Builder underlyer;
		
		@Override
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("informationSource")
		public InformationSource.InformationSourceBuilder getInformationSource() {
			return informationSource;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder getOrCreateInformationSource() {
			InformationSource.InformationSourceBuilder result;
			if (informationSource!=null) {
				result = informationSource;
			}
			else {
				result = informationSource = InformationSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyer")
		public TradeUnderlyer2.TradeUnderlyer2Builder getUnderlyer() {
			return underlyer;
		}
		
		@Override
		public TradeUnderlyer2.TradeUnderlyer2Builder getOrCreateUnderlyer() {
			TradeUnderlyer2.TradeUnderlyer2Builder result;
			if (underlyer!=null) {
				result = underlyer;
			}
			else {
				result = underlyer = TradeUnderlyer2.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("informationSource")
		@Override
		public ObservationSource.ObservationSourceBuilder setInformationSource(InformationSource _informationSource) {
			this.informationSource = _informationSource == null ? null : _informationSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyer")
		@Override
		public ObservationSource.ObservationSourceBuilder setUnderlyer(TradeUnderlyer2 _underlyer) {
			this.underlyer = _underlyer == null ? null : _underlyer.toBuilder();
			return this;
		}
		
		@Override
		public ObservationSource build() {
			return new ObservationSource.ObservationSourceImpl(this);
		}
		
		@Override
		public ObservationSource.ObservationSourceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservationSource.ObservationSourceBuilder prune() {
			if (informationSource!=null && !informationSource.prune().hasData()) informationSource = null;
			if (underlyer!=null && !underlyer.prune().hasData()) underlyer = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInformationSource()!=null && getInformationSource().hasData()) return true;
			if (getUnderlyer()!=null && getUnderlyer().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservationSource.ObservationSourceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ObservationSource.ObservationSourceBuilder o = (ObservationSource.ObservationSourceBuilder) other;
			
			merger.mergeRosetta(getInformationSource(), o.getInformationSource(), this::setInformationSource);
			merger.mergeRosetta(getUnderlyer(), o.getUnderlyer(), this::setUnderlyer);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObservationSource _that = getType().cast(o);
		
			if (!Objects.equals(informationSource, _that.getInformationSource())) return false;
			if (!Objects.equals(underlyer, _that.getUnderlyer())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservationSourceBuilder {" +
				"informationSource=" + this.informationSource + ", " +
				"underlyer=" + this.underlyer +
			'}';
		}
	}
}
