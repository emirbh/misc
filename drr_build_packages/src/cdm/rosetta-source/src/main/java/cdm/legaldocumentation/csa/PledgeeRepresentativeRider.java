package cdm.legaldocumentation.csa;

import cdm.base.datetime.CustomisableOffset;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.meta.PledgeeRepresentativeRiderMeta;
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
 * The terms of the Rider for the ISDA Euroclear 2019 Collateral Transfer Agreement with respect to the use of a Pledgee Representative attached to this Agreement.
 * @version 6.23.0
 */
@RosettaDataType(value="PledgeeRepresentativeRider", builder=PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilderImpl.class, version="6.23.0")
@RuneDataType(value="PledgeeRepresentativeRider", model="cdm", builder=PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilderImpl.class, version="6.23.0")
public interface PledgeeRepresentativeRider extends RosettaModelObject {

	PledgeeRepresentativeRiderMeta metaData = new PledgeeRepresentativeRiderMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identification of whether the representative CTA provisions are applicable (True) or not applicable (False).
	 */
	Boolean getIsApplicable();
	/**
	 * Identification of the represented party.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * The specific representative terms applicable when specified.
	 */
	String getRepresentativeTerms();
	/**
	 * The specification of whether the representative event terms are applicable.
	 */
	ExceptionEnum getRepresentativeEvent();
	/**
	 * The specific representative event terms applicable when specified.
	 */
	String getRepresentativeEventTerms();
	/**
	 * The definition of representative end date in relation to a representative event.
	 */
	CustomisableOffset getRepresentativeEndDate();

	/*********************** Build Methods  ***********************/
	PledgeeRepresentativeRider build();
	
	PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder toBuilder();
	
	static PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder builder() {
		return new PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PledgeeRepresentativeRider> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PledgeeRepresentativeRider> getType() {
		return PledgeeRepresentativeRider.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("representativeTerms"), String.class, getRepresentativeTerms(), this);
		processor.processBasic(path.newSubPath("representativeEvent"), ExceptionEnum.class, getRepresentativeEvent(), this);
		processor.processBasic(path.newSubPath("representativeEventTerms"), String.class, getRepresentativeEventTerms(), this);
		processRosetta(path.newSubPath("representativeEndDate"), processor, CustomisableOffset.class, getRepresentativeEndDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PledgeeRepresentativeRiderBuilder extends PledgeeRepresentativeRider, RosettaModelObjectBuilder {
		CustomisableOffset.CustomisableOffsetBuilder getOrCreateRepresentativeEndDate();
		@Override
		CustomisableOffset.CustomisableOffsetBuilder getRepresentativeEndDate();
		PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder setIsApplicable(Boolean isApplicable);
		PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder setParty(CounterpartyRoleEnum party);
		PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder setRepresentativeTerms(String representativeTerms);
		PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder setRepresentativeEvent(ExceptionEnum representativeEvent);
		PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder setRepresentativeEventTerms(String representativeEventTerms);
		PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder setRepresentativeEndDate(CustomisableOffset representativeEndDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("representativeTerms"), String.class, getRepresentativeTerms(), this);
			processor.processBasic(path.newSubPath("representativeEvent"), ExceptionEnum.class, getRepresentativeEvent(), this);
			processor.processBasic(path.newSubPath("representativeEventTerms"), String.class, getRepresentativeEventTerms(), this);
			processRosetta(path.newSubPath("representativeEndDate"), processor, CustomisableOffset.CustomisableOffsetBuilder.class, getRepresentativeEndDate());
		}
		

		PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder prune();
	}

	/*********************** Immutable Implementation of PledgeeRepresentativeRider  ***********************/
	class PledgeeRepresentativeRiderImpl implements PledgeeRepresentativeRider {
		private final Boolean isApplicable;
		private final CounterpartyRoleEnum party;
		private final String representativeTerms;
		private final ExceptionEnum representativeEvent;
		private final String representativeEventTerms;
		private final CustomisableOffset representativeEndDate;
		
		protected PledgeeRepresentativeRiderImpl(PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder builder) {
			this.isApplicable = builder.getIsApplicable();
			this.party = builder.getParty();
			this.representativeTerms = builder.getRepresentativeTerms();
			this.representativeEvent = builder.getRepresentativeEvent();
			this.representativeEventTerms = builder.getRepresentativeEventTerms();
			this.representativeEndDate = ofNullable(builder.getRepresentativeEndDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isApplicable")
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("representativeTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("representativeTerms")
		public String getRepresentativeTerms() {
			return representativeTerms;
		}
		
		@Override
		@RosettaAttribute("representativeEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("representativeEvent")
		public ExceptionEnum getRepresentativeEvent() {
			return representativeEvent;
		}
		
		@Override
		@RosettaAttribute("representativeEventTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("representativeEventTerms")
		public String getRepresentativeEventTerms() {
			return representativeEventTerms;
		}
		
		@Override
		@RosettaAttribute("representativeEndDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("representativeEndDate")
		public CustomisableOffset getRepresentativeEndDate() {
			return representativeEndDate;
		}
		
		@Override
		public PledgeeRepresentativeRider build() {
			return this;
		}
		
		@Override
		public PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder toBuilder() {
			PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder builder) {
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getRepresentativeTerms()).ifPresent(builder::setRepresentativeTerms);
			ofNullable(getRepresentativeEvent()).ifPresent(builder::setRepresentativeEvent);
			ofNullable(getRepresentativeEventTerms()).ifPresent(builder::setRepresentativeEventTerms);
			ofNullable(getRepresentativeEndDate()).ifPresent(builder::setRepresentativeEndDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PledgeeRepresentativeRider _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(representativeTerms, _that.getRepresentativeTerms())) return false;
			if (!Objects.equals(representativeEvent, _that.getRepresentativeEvent())) return false;
			if (!Objects.equals(representativeEventTerms, _that.getRepresentativeEventTerms())) return false;
			if (!Objects.equals(representativeEndDate, _that.getRepresentativeEndDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (representativeTerms != null ? representativeTerms.hashCode() : 0);
			_result = 31 * _result + (representativeEvent != null ? representativeEvent.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (representativeEventTerms != null ? representativeEventTerms.hashCode() : 0);
			_result = 31 * _result + (representativeEndDate != null ? representativeEndDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PledgeeRepresentativeRider {" +
				"isApplicable=" + this.isApplicable + ", " +
				"party=" + this.party + ", " +
				"representativeTerms=" + this.representativeTerms + ", " +
				"representativeEvent=" + this.representativeEvent + ", " +
				"representativeEventTerms=" + this.representativeEventTerms + ", " +
				"representativeEndDate=" + this.representativeEndDate +
			'}';
		}
	}

	/*********************** Builder Implementation of PledgeeRepresentativeRider  ***********************/
	class PledgeeRepresentativeRiderBuilderImpl implements PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder {
	
		protected Boolean isApplicable;
		protected CounterpartyRoleEnum party;
		protected String representativeTerms;
		protected ExceptionEnum representativeEvent;
		protected String representativeEventTerms;
		protected CustomisableOffset.CustomisableOffsetBuilder representativeEndDate;
		
		@Override
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isApplicable")
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("representativeTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("representativeTerms")
		public String getRepresentativeTerms() {
			return representativeTerms;
		}
		
		@Override
		@RosettaAttribute("representativeEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("representativeEvent")
		public ExceptionEnum getRepresentativeEvent() {
			return representativeEvent;
		}
		
		@Override
		@RosettaAttribute("representativeEventTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("representativeEventTerms")
		public String getRepresentativeEventTerms() {
			return representativeEventTerms;
		}
		
		@Override
		@RosettaAttribute("representativeEndDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("representativeEndDate")
		public CustomisableOffset.CustomisableOffsetBuilder getRepresentativeEndDate() {
			return representativeEndDate;
		}
		
		@Override
		public CustomisableOffset.CustomisableOffsetBuilder getOrCreateRepresentativeEndDate() {
			CustomisableOffset.CustomisableOffsetBuilder result;
			if (representativeEndDate!=null) {
				result = representativeEndDate;
			}
			else {
				result = representativeEndDate = CustomisableOffset.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("isApplicable")
		@Override
		public PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder setIsApplicable(Boolean _isApplicable) {
			this.isApplicable = _isApplicable == null ? null : _isApplicable;
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("party")
		@Override
		public PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder setParty(CounterpartyRoleEnum _party) {
			this.party = _party == null ? null : _party;
			return this;
		}
		
		@RosettaAttribute("representativeTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("representativeTerms")
		@Override
		public PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder setRepresentativeTerms(String _representativeTerms) {
			this.representativeTerms = _representativeTerms == null ? null : _representativeTerms;
			return this;
		}
		
		@RosettaAttribute("representativeEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("representativeEvent")
		@Override
		public PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder setRepresentativeEvent(ExceptionEnum _representativeEvent) {
			this.representativeEvent = _representativeEvent == null ? null : _representativeEvent;
			return this;
		}
		
		@RosettaAttribute("representativeEventTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("representativeEventTerms")
		@Override
		public PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder setRepresentativeEventTerms(String _representativeEventTerms) {
			this.representativeEventTerms = _representativeEventTerms == null ? null : _representativeEventTerms;
			return this;
		}
		
		@RosettaAttribute("representativeEndDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("representativeEndDate")
		@Override
		public PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder setRepresentativeEndDate(CustomisableOffset _representativeEndDate) {
			this.representativeEndDate = _representativeEndDate == null ? null : _representativeEndDate.toBuilder();
			return this;
		}
		
		@Override
		public PledgeeRepresentativeRider build() {
			return new PledgeeRepresentativeRider.PledgeeRepresentativeRiderImpl(this);
		}
		
		@Override
		public PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder prune() {
			if (representativeEndDate!=null && !representativeEndDate.prune().hasData()) representativeEndDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsApplicable()!=null) return true;
			if (getParty()!=null) return true;
			if (getRepresentativeTerms()!=null) return true;
			if (getRepresentativeEvent()!=null) return true;
			if (getRepresentativeEventTerms()!=null) return true;
			if (getRepresentativeEndDate()!=null && getRepresentativeEndDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder o = (PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder) other;
			
			merger.mergeRosetta(getRepresentativeEndDate(), o.getRepresentativeEndDate(), this::setRepresentativeEndDate);
			
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getRepresentativeTerms(), o.getRepresentativeTerms(), this::setRepresentativeTerms);
			merger.mergeBasic(getRepresentativeEvent(), o.getRepresentativeEvent(), this::setRepresentativeEvent);
			merger.mergeBasic(getRepresentativeEventTerms(), o.getRepresentativeEventTerms(), this::setRepresentativeEventTerms);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PledgeeRepresentativeRider _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(representativeTerms, _that.getRepresentativeTerms())) return false;
			if (!Objects.equals(representativeEvent, _that.getRepresentativeEvent())) return false;
			if (!Objects.equals(representativeEventTerms, _that.getRepresentativeEventTerms())) return false;
			if (!Objects.equals(representativeEndDate, _that.getRepresentativeEndDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (representativeTerms != null ? representativeTerms.hashCode() : 0);
			_result = 31 * _result + (representativeEvent != null ? representativeEvent.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (representativeEventTerms != null ? representativeEventTerms.hashCode() : 0);
			_result = 31 * _result + (representativeEndDate != null ? representativeEndDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PledgeeRepresentativeRiderBuilder {" +
				"isApplicable=" + this.isApplicable + ", " +
				"party=" + this.party + ", " +
				"representativeTerms=" + this.representativeTerms + ", " +
				"representativeEvent=" + this.representativeEvent + ", " +
				"representativeEventTerms=" + this.representativeEventTerms + ", " +
				"representativeEndDate=" + this.representativeEndDate +
			'}';
		}
	}
}
