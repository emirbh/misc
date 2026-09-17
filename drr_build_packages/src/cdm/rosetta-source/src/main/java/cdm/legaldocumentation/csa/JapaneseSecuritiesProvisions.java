package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.JapaneseSecuritiesProvisionsMeta;
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
 * A class to specify Japanese Securities Provision elections.
 * @version 6.23.0
 */
@RosettaDataType(value="JapaneseSecuritiesProvisions", builder=JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="JapaneseSecuritiesProvisions", model="cdm", builder=JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilderImpl.class, version="6.23.0")
public interface JapaneseSecuritiesProvisions extends RosettaModelObject {

	JapaneseSecuritiesProvisionsMeta metaData = new JapaneseSecuritiesProvisionsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Japanese Securities Provisions are applicable when True and Not Applicable when False.
	 */
	Boolean getIsApplicable();
	/**
	 * Recommended Japanese Securities Provisions are applicable when True, additional Provisions are specified when False.
	 */
	Boolean getRelevantProvisionsElection();
	/**
	 * Specific terms applicable to Recommended Japanese Securities Provisions.
	 */
	String getRelevantProvisionsTerms();
	/**
	 * Additional Amendments to Japanese Securities Provisions are specified when True, and not specified when False.
	 */
	Boolean getAmendmentsToJapaneseProvisions();
	/**
	 * Specific terms applicable to Additional Amendments to Japanese Securities Provisions.
	 */
	String getAmendmentsToJapaneseProvisionsTerms();
	/**
	 * Specification of whether Clearstream Event amendment language is included (true) or excluded (false).
	 */
	Boolean getClearstreamAmendmentToJapaneseProvisions();

	/*********************** Build Methods  ***********************/
	JapaneseSecuritiesProvisions build();
	
	JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder toBuilder();
	
	static JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder builder() {
		return new JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends JapaneseSecuritiesProvisions> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends JapaneseSecuritiesProvisions> getType() {
		return JapaneseSecuritiesProvisions.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		processor.processBasic(path.newSubPath("relevantProvisionsElection"), Boolean.class, getRelevantProvisionsElection(), this);
		processor.processBasic(path.newSubPath("relevantProvisionsTerms"), String.class, getRelevantProvisionsTerms(), this);
		processor.processBasic(path.newSubPath("amendmentsToJapaneseProvisions"), Boolean.class, getAmendmentsToJapaneseProvisions(), this);
		processor.processBasic(path.newSubPath("amendmentsToJapaneseProvisionsTerms"), String.class, getAmendmentsToJapaneseProvisionsTerms(), this);
		processor.processBasic(path.newSubPath("clearstreamAmendmentToJapaneseProvisions"), Boolean.class, getClearstreamAmendmentToJapaneseProvisions(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface JapaneseSecuritiesProvisionsBuilder extends JapaneseSecuritiesProvisions, RosettaModelObjectBuilder {
		JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder setIsApplicable(Boolean isApplicable);
		JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder setRelevantProvisionsElection(Boolean relevantProvisionsElection);
		JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder setRelevantProvisionsTerms(String relevantProvisionsTerms);
		JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder setAmendmentsToJapaneseProvisions(Boolean amendmentsToJapaneseProvisions);
		JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder setAmendmentsToJapaneseProvisionsTerms(String amendmentsToJapaneseProvisionsTerms);
		JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder setClearstreamAmendmentToJapaneseProvisions(Boolean clearstreamAmendmentToJapaneseProvisions);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
			processor.processBasic(path.newSubPath("relevantProvisionsElection"), Boolean.class, getRelevantProvisionsElection(), this);
			processor.processBasic(path.newSubPath("relevantProvisionsTerms"), String.class, getRelevantProvisionsTerms(), this);
			processor.processBasic(path.newSubPath("amendmentsToJapaneseProvisions"), Boolean.class, getAmendmentsToJapaneseProvisions(), this);
			processor.processBasic(path.newSubPath("amendmentsToJapaneseProvisionsTerms"), String.class, getAmendmentsToJapaneseProvisionsTerms(), this);
			processor.processBasic(path.newSubPath("clearstreamAmendmentToJapaneseProvisions"), Boolean.class, getClearstreamAmendmentToJapaneseProvisions(), this);
		}
		

		JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder prune();
	}

	/*********************** Immutable Implementation of JapaneseSecuritiesProvisions  ***********************/
	class JapaneseSecuritiesProvisionsImpl implements JapaneseSecuritiesProvisions {
		private final Boolean isApplicable;
		private final Boolean relevantProvisionsElection;
		private final String relevantProvisionsTerms;
		private final Boolean amendmentsToJapaneseProvisions;
		private final String amendmentsToJapaneseProvisionsTerms;
		private final Boolean clearstreamAmendmentToJapaneseProvisions;
		
		protected JapaneseSecuritiesProvisionsImpl(JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder builder) {
			this.isApplicable = builder.getIsApplicable();
			this.relevantProvisionsElection = builder.getRelevantProvisionsElection();
			this.relevantProvisionsTerms = builder.getRelevantProvisionsTerms();
			this.amendmentsToJapaneseProvisions = builder.getAmendmentsToJapaneseProvisions();
			this.amendmentsToJapaneseProvisionsTerms = builder.getAmendmentsToJapaneseProvisionsTerms();
			this.clearstreamAmendmentToJapaneseProvisions = builder.getClearstreamAmendmentToJapaneseProvisions();
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
		@RosettaAttribute("relevantProvisionsElection")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relevantProvisionsElection")
		public Boolean getRelevantProvisionsElection() {
			return relevantProvisionsElection;
		}
		
		@Override
		@RosettaAttribute("relevantProvisionsTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relevantProvisionsTerms")
		public String getRelevantProvisionsTerms() {
			return relevantProvisionsTerms;
		}
		
		@Override
		@RosettaAttribute("amendmentsToJapaneseProvisions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amendmentsToJapaneseProvisions")
		public Boolean getAmendmentsToJapaneseProvisions() {
			return amendmentsToJapaneseProvisions;
		}
		
		@Override
		@RosettaAttribute("amendmentsToJapaneseProvisionsTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amendmentsToJapaneseProvisionsTerms")
		public String getAmendmentsToJapaneseProvisionsTerms() {
			return amendmentsToJapaneseProvisionsTerms;
		}
		
		@Override
		@RosettaAttribute("clearstreamAmendmentToJapaneseProvisions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearstreamAmendmentToJapaneseProvisions")
		public Boolean getClearstreamAmendmentToJapaneseProvisions() {
			return clearstreamAmendmentToJapaneseProvisions;
		}
		
		@Override
		public JapaneseSecuritiesProvisions build() {
			return this;
		}
		
		@Override
		public JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder toBuilder() {
			JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder builder) {
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
			ofNullable(getRelevantProvisionsElection()).ifPresent(builder::setRelevantProvisionsElection);
			ofNullable(getRelevantProvisionsTerms()).ifPresent(builder::setRelevantProvisionsTerms);
			ofNullable(getAmendmentsToJapaneseProvisions()).ifPresent(builder::setAmendmentsToJapaneseProvisions);
			ofNullable(getAmendmentsToJapaneseProvisionsTerms()).ifPresent(builder::setAmendmentsToJapaneseProvisionsTerms);
			ofNullable(getClearstreamAmendmentToJapaneseProvisions()).ifPresent(builder::setClearstreamAmendmentToJapaneseProvisions);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			JapaneseSecuritiesProvisions _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(relevantProvisionsElection, _that.getRelevantProvisionsElection())) return false;
			if (!Objects.equals(relevantProvisionsTerms, _that.getRelevantProvisionsTerms())) return false;
			if (!Objects.equals(amendmentsToJapaneseProvisions, _that.getAmendmentsToJapaneseProvisions())) return false;
			if (!Objects.equals(amendmentsToJapaneseProvisionsTerms, _that.getAmendmentsToJapaneseProvisionsTerms())) return false;
			if (!Objects.equals(clearstreamAmendmentToJapaneseProvisions, _that.getClearstreamAmendmentToJapaneseProvisions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (relevantProvisionsElection != null ? relevantProvisionsElection.hashCode() : 0);
			_result = 31 * _result + (relevantProvisionsTerms != null ? relevantProvisionsTerms.hashCode() : 0);
			_result = 31 * _result + (amendmentsToJapaneseProvisions != null ? amendmentsToJapaneseProvisions.hashCode() : 0);
			_result = 31 * _result + (amendmentsToJapaneseProvisionsTerms != null ? amendmentsToJapaneseProvisionsTerms.hashCode() : 0);
			_result = 31 * _result + (clearstreamAmendmentToJapaneseProvisions != null ? clearstreamAmendmentToJapaneseProvisions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "JapaneseSecuritiesProvisions {" +
				"isApplicable=" + this.isApplicable + ", " +
				"relevantProvisionsElection=" + this.relevantProvisionsElection + ", " +
				"relevantProvisionsTerms=" + this.relevantProvisionsTerms + ", " +
				"amendmentsToJapaneseProvisions=" + this.amendmentsToJapaneseProvisions + ", " +
				"amendmentsToJapaneseProvisionsTerms=" + this.amendmentsToJapaneseProvisionsTerms + ", " +
				"clearstreamAmendmentToJapaneseProvisions=" + this.clearstreamAmendmentToJapaneseProvisions +
			'}';
		}
	}

	/*********************** Builder Implementation of JapaneseSecuritiesProvisions  ***********************/
	class JapaneseSecuritiesProvisionsBuilderImpl implements JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder {
	
		protected Boolean isApplicable;
		protected Boolean relevantProvisionsElection;
		protected String relevantProvisionsTerms;
		protected Boolean amendmentsToJapaneseProvisions;
		protected String amendmentsToJapaneseProvisionsTerms;
		protected Boolean clearstreamAmendmentToJapaneseProvisions;
		
		@Override
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isApplicable")
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		@RosettaAttribute("relevantProvisionsElection")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relevantProvisionsElection")
		public Boolean getRelevantProvisionsElection() {
			return relevantProvisionsElection;
		}
		
		@Override
		@RosettaAttribute("relevantProvisionsTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relevantProvisionsTerms")
		public String getRelevantProvisionsTerms() {
			return relevantProvisionsTerms;
		}
		
		@Override
		@RosettaAttribute("amendmentsToJapaneseProvisions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amendmentsToJapaneseProvisions")
		public Boolean getAmendmentsToJapaneseProvisions() {
			return amendmentsToJapaneseProvisions;
		}
		
		@Override
		@RosettaAttribute("amendmentsToJapaneseProvisionsTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amendmentsToJapaneseProvisionsTerms")
		public String getAmendmentsToJapaneseProvisionsTerms() {
			return amendmentsToJapaneseProvisionsTerms;
		}
		
		@Override
		@RosettaAttribute("clearstreamAmendmentToJapaneseProvisions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearstreamAmendmentToJapaneseProvisions")
		public Boolean getClearstreamAmendmentToJapaneseProvisions() {
			return clearstreamAmendmentToJapaneseProvisions;
		}
		
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("isApplicable")
		@Override
		public JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder setIsApplicable(Boolean _isApplicable) {
			this.isApplicable = _isApplicable == null ? null : _isApplicable;
			return this;
		}
		
		@RosettaAttribute("relevantProvisionsElection")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relevantProvisionsElection")
		@Override
		public JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder setRelevantProvisionsElection(Boolean _relevantProvisionsElection) {
			this.relevantProvisionsElection = _relevantProvisionsElection == null ? null : _relevantProvisionsElection;
			return this;
		}
		
		@RosettaAttribute("relevantProvisionsTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relevantProvisionsTerms")
		@Override
		public JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder setRelevantProvisionsTerms(String _relevantProvisionsTerms) {
			this.relevantProvisionsTerms = _relevantProvisionsTerms == null ? null : _relevantProvisionsTerms;
			return this;
		}
		
		@RosettaAttribute("amendmentsToJapaneseProvisions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amendmentsToJapaneseProvisions")
		@Override
		public JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder setAmendmentsToJapaneseProvisions(Boolean _amendmentsToJapaneseProvisions) {
			this.amendmentsToJapaneseProvisions = _amendmentsToJapaneseProvisions == null ? null : _amendmentsToJapaneseProvisions;
			return this;
		}
		
		@RosettaAttribute("amendmentsToJapaneseProvisionsTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amendmentsToJapaneseProvisionsTerms")
		@Override
		public JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder setAmendmentsToJapaneseProvisionsTerms(String _amendmentsToJapaneseProvisionsTerms) {
			this.amendmentsToJapaneseProvisionsTerms = _amendmentsToJapaneseProvisionsTerms == null ? null : _amendmentsToJapaneseProvisionsTerms;
			return this;
		}
		
		@RosettaAttribute("clearstreamAmendmentToJapaneseProvisions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearstreamAmendmentToJapaneseProvisions")
		@Override
		public JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder setClearstreamAmendmentToJapaneseProvisions(Boolean _clearstreamAmendmentToJapaneseProvisions) {
			this.clearstreamAmendmentToJapaneseProvisions = _clearstreamAmendmentToJapaneseProvisions == null ? null : _clearstreamAmendmentToJapaneseProvisions;
			return this;
		}
		
		@Override
		public JapaneseSecuritiesProvisions build() {
			return new JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsImpl(this);
		}
		
		@Override
		public JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsApplicable()!=null) return true;
			if (getRelevantProvisionsElection()!=null) return true;
			if (getRelevantProvisionsTerms()!=null) return true;
			if (getAmendmentsToJapaneseProvisions()!=null) return true;
			if (getAmendmentsToJapaneseProvisionsTerms()!=null) return true;
			if (getClearstreamAmendmentToJapaneseProvisions()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder o = (JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder) other;
			
			
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			merger.mergeBasic(getRelevantProvisionsElection(), o.getRelevantProvisionsElection(), this::setRelevantProvisionsElection);
			merger.mergeBasic(getRelevantProvisionsTerms(), o.getRelevantProvisionsTerms(), this::setRelevantProvisionsTerms);
			merger.mergeBasic(getAmendmentsToJapaneseProvisions(), o.getAmendmentsToJapaneseProvisions(), this::setAmendmentsToJapaneseProvisions);
			merger.mergeBasic(getAmendmentsToJapaneseProvisionsTerms(), o.getAmendmentsToJapaneseProvisionsTerms(), this::setAmendmentsToJapaneseProvisionsTerms);
			merger.mergeBasic(getClearstreamAmendmentToJapaneseProvisions(), o.getClearstreamAmendmentToJapaneseProvisions(), this::setClearstreamAmendmentToJapaneseProvisions);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			JapaneseSecuritiesProvisions _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(relevantProvisionsElection, _that.getRelevantProvisionsElection())) return false;
			if (!Objects.equals(relevantProvisionsTerms, _that.getRelevantProvisionsTerms())) return false;
			if (!Objects.equals(amendmentsToJapaneseProvisions, _that.getAmendmentsToJapaneseProvisions())) return false;
			if (!Objects.equals(amendmentsToJapaneseProvisionsTerms, _that.getAmendmentsToJapaneseProvisionsTerms())) return false;
			if (!Objects.equals(clearstreamAmendmentToJapaneseProvisions, _that.getClearstreamAmendmentToJapaneseProvisions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (relevantProvisionsElection != null ? relevantProvisionsElection.hashCode() : 0);
			_result = 31 * _result + (relevantProvisionsTerms != null ? relevantProvisionsTerms.hashCode() : 0);
			_result = 31 * _result + (amendmentsToJapaneseProvisions != null ? amendmentsToJapaneseProvisions.hashCode() : 0);
			_result = 31 * _result + (amendmentsToJapaneseProvisionsTerms != null ? amendmentsToJapaneseProvisionsTerms.hashCode() : 0);
			_result = 31 * _result + (clearstreamAmendmentToJapaneseProvisions != null ? clearstreamAmendmentToJapaneseProvisions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "JapaneseSecuritiesProvisionsBuilder {" +
				"isApplicable=" + this.isApplicable + ", " +
				"relevantProvisionsElection=" + this.relevantProvisionsElection + ", " +
				"relevantProvisionsTerms=" + this.relevantProvisionsTerms + ", " +
				"amendmentsToJapaneseProvisions=" + this.amendmentsToJapaneseProvisions + ", " +
				"amendmentsToJapaneseProvisionsTerms=" + this.amendmentsToJapaneseProvisionsTerms + ", " +
				"clearstreamAmendmentToJapaneseProvisions=" + this.clearstreamAmendmentToJapaneseProvisions +
			'}';
		}
	}
}
