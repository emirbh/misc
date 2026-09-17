package cdm.legaldocumentation.transaction.additionalterms;

import cdm.legaldocumentation.transaction.additionalterms.meta.FxAdditionalTermsMeta;
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
 * TransactionAdditionalTerms which apply to the CurrencyPair asset class.
 * @version 6.23.0
 */
@RosettaDataType(value="FxAdditionalTerms", builder=FxAdditionalTerms.FxAdditionalTermsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="FxAdditionalTerms", model="cdm", builder=FxAdditionalTerms.FxAdditionalTermsBuilderImpl.class, version="6.23.0")
public interface FxAdditionalTerms extends RosettaModelObject {

	FxAdditionalTermsMeta metaData = new FxAdditionalTermsMeta();

	/*********************** Getter Methods  ***********************/
	FxDisruptionEvents getDisruptionEvents();
	DeterminationRolesAndTerms getDeterminationTerms();
	Boolean getNoFaultTermination();

	/*********************** Build Methods  ***********************/
	FxAdditionalTerms build();
	
	FxAdditionalTerms.FxAdditionalTermsBuilder toBuilder();
	
	static FxAdditionalTerms.FxAdditionalTermsBuilder builder() {
		return new FxAdditionalTerms.FxAdditionalTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAdditionalTerms> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxAdditionalTerms> getType() {
		return FxAdditionalTerms.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("disruptionEvents"), processor, FxDisruptionEvents.class, getDisruptionEvents());
		processRosetta(path.newSubPath("determinationTerms"), processor, DeterminationRolesAndTerms.class, getDeterminationTerms());
		processor.processBasic(path.newSubPath("noFaultTermination"), Boolean.class, getNoFaultTermination(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAdditionalTermsBuilder extends FxAdditionalTerms, RosettaModelObjectBuilder {
		FxDisruptionEvents.FxDisruptionEventsBuilder getOrCreateDisruptionEvents();
		@Override
		FxDisruptionEvents.FxDisruptionEventsBuilder getDisruptionEvents();
		DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder getOrCreateDeterminationTerms();
		@Override
		DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder getDeterminationTerms();
		FxAdditionalTerms.FxAdditionalTermsBuilder setDisruptionEvents(FxDisruptionEvents disruptionEvents);
		FxAdditionalTerms.FxAdditionalTermsBuilder setDeterminationTerms(DeterminationRolesAndTerms determinationTerms);
		FxAdditionalTerms.FxAdditionalTermsBuilder setNoFaultTermination(Boolean noFaultTermination);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("disruptionEvents"), processor, FxDisruptionEvents.FxDisruptionEventsBuilder.class, getDisruptionEvents());
			processRosetta(path.newSubPath("determinationTerms"), processor, DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder.class, getDeterminationTerms());
			processor.processBasic(path.newSubPath("noFaultTermination"), Boolean.class, getNoFaultTermination(), this);
		}
		

		FxAdditionalTerms.FxAdditionalTermsBuilder prune();
	}

	/*********************** Immutable Implementation of FxAdditionalTerms  ***********************/
	class FxAdditionalTermsImpl implements FxAdditionalTerms {
		private final FxDisruptionEvents disruptionEvents;
		private final DeterminationRolesAndTerms determinationTerms;
		private final Boolean noFaultTermination;
		
		protected FxAdditionalTermsImpl(FxAdditionalTerms.FxAdditionalTermsBuilder builder) {
			this.disruptionEvents = ofNullable(builder.getDisruptionEvents()).map(f->f.build()).orElse(null);
			this.determinationTerms = ofNullable(builder.getDeterminationTerms()).map(f->f.build()).orElse(null);
			this.noFaultTermination = builder.getNoFaultTermination();
		}
		
		@Override
		@RosettaAttribute("disruptionEvents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("disruptionEvents")
		public FxDisruptionEvents getDisruptionEvents() {
			return disruptionEvents;
		}
		
		@Override
		@RosettaAttribute("determinationTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("determinationTerms")
		public DeterminationRolesAndTerms getDeterminationTerms() {
			return determinationTerms;
		}
		
		@Override
		@RosettaAttribute("noFaultTermination")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("noFaultTermination")
		public Boolean getNoFaultTermination() {
			return noFaultTermination;
		}
		
		@Override
		public FxAdditionalTerms build() {
			return this;
		}
		
		@Override
		public FxAdditionalTerms.FxAdditionalTermsBuilder toBuilder() {
			FxAdditionalTerms.FxAdditionalTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAdditionalTerms.FxAdditionalTermsBuilder builder) {
			ofNullable(getDisruptionEvents()).ifPresent(builder::setDisruptionEvents);
			ofNullable(getDeterminationTerms()).ifPresent(builder::setDeterminationTerms);
			ofNullable(getNoFaultTermination()).ifPresent(builder::setNoFaultTermination);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAdditionalTerms _that = getType().cast(o);
		
			if (!Objects.equals(disruptionEvents, _that.getDisruptionEvents())) return false;
			if (!Objects.equals(determinationTerms, _that.getDeterminationTerms())) return false;
			if (!Objects.equals(noFaultTermination, _that.getNoFaultTermination())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (disruptionEvents != null ? disruptionEvents.hashCode() : 0);
			_result = 31 * _result + (determinationTerms != null ? determinationTerms.hashCode() : 0);
			_result = 31 * _result + (noFaultTermination != null ? noFaultTermination.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAdditionalTerms {" +
				"disruptionEvents=" + this.disruptionEvents + ", " +
				"determinationTerms=" + this.determinationTerms + ", " +
				"noFaultTermination=" + this.noFaultTermination +
			'}';
		}
	}

	/*********************** Builder Implementation of FxAdditionalTerms  ***********************/
	class FxAdditionalTermsBuilderImpl implements FxAdditionalTerms.FxAdditionalTermsBuilder {
	
		protected FxDisruptionEvents.FxDisruptionEventsBuilder disruptionEvents;
		protected DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder determinationTerms;
		protected Boolean noFaultTermination;
		
		@Override
		@RosettaAttribute("disruptionEvents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("disruptionEvents")
		public FxDisruptionEvents.FxDisruptionEventsBuilder getDisruptionEvents() {
			return disruptionEvents;
		}
		
		@Override
		public FxDisruptionEvents.FxDisruptionEventsBuilder getOrCreateDisruptionEvents() {
			FxDisruptionEvents.FxDisruptionEventsBuilder result;
			if (disruptionEvents!=null) {
				result = disruptionEvents;
			}
			else {
				result = disruptionEvents = FxDisruptionEvents.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("determinationTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("determinationTerms")
		public DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder getDeterminationTerms() {
			return determinationTerms;
		}
		
		@Override
		public DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder getOrCreateDeterminationTerms() {
			DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder result;
			if (determinationTerms!=null) {
				result = determinationTerms;
			}
			else {
				result = determinationTerms = DeterminationRolesAndTerms.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("noFaultTermination")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("noFaultTermination")
		public Boolean getNoFaultTermination() {
			return noFaultTermination;
		}
		
		@RosettaAttribute("disruptionEvents")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("disruptionEvents")
		@Override
		public FxAdditionalTerms.FxAdditionalTermsBuilder setDisruptionEvents(FxDisruptionEvents _disruptionEvents) {
			this.disruptionEvents = _disruptionEvents == null ? null : _disruptionEvents.toBuilder();
			return this;
		}
		
		@RosettaAttribute("determinationTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("determinationTerms")
		@Override
		public FxAdditionalTerms.FxAdditionalTermsBuilder setDeterminationTerms(DeterminationRolesAndTerms _determinationTerms) {
			this.determinationTerms = _determinationTerms == null ? null : _determinationTerms.toBuilder();
			return this;
		}
		
		@RosettaAttribute("noFaultTermination")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("noFaultTermination")
		@Override
		public FxAdditionalTerms.FxAdditionalTermsBuilder setNoFaultTermination(Boolean _noFaultTermination) {
			this.noFaultTermination = _noFaultTermination == null ? null : _noFaultTermination;
			return this;
		}
		
		@Override
		public FxAdditionalTerms build() {
			return new FxAdditionalTerms.FxAdditionalTermsImpl(this);
		}
		
		@Override
		public FxAdditionalTerms.FxAdditionalTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAdditionalTerms.FxAdditionalTermsBuilder prune() {
			if (disruptionEvents!=null && !disruptionEvents.prune().hasData()) disruptionEvents = null;
			if (determinationTerms!=null && !determinationTerms.prune().hasData()) determinationTerms = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDisruptionEvents()!=null && getDisruptionEvents().hasData()) return true;
			if (getDeterminationTerms()!=null && getDeterminationTerms().hasData()) return true;
			if (getNoFaultTermination()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAdditionalTerms.FxAdditionalTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxAdditionalTerms.FxAdditionalTermsBuilder o = (FxAdditionalTerms.FxAdditionalTermsBuilder) other;
			
			merger.mergeRosetta(getDisruptionEvents(), o.getDisruptionEvents(), this::setDisruptionEvents);
			merger.mergeRosetta(getDeterminationTerms(), o.getDeterminationTerms(), this::setDeterminationTerms);
			
			merger.mergeBasic(getNoFaultTermination(), o.getNoFaultTermination(), this::setNoFaultTermination);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAdditionalTerms _that = getType().cast(o);
		
			if (!Objects.equals(disruptionEvents, _that.getDisruptionEvents())) return false;
			if (!Objects.equals(determinationTerms, _that.getDeterminationTerms())) return false;
			if (!Objects.equals(noFaultTermination, _that.getNoFaultTermination())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (disruptionEvents != null ? disruptionEvents.hashCode() : 0);
			_result = 31 * _result + (determinationTerms != null ? determinationTerms.hashCode() : 0);
			_result = 31 * _result + (noFaultTermination != null ? noFaultTermination.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAdditionalTermsBuilder {" +
				"disruptionEvents=" + this.disruptionEvents + ", " +
				"determinationTerms=" + this.determinationTerms + ", " +
				"noFaultTermination=" + this.noFaultTermination +
			'}';
		}
	}
}
