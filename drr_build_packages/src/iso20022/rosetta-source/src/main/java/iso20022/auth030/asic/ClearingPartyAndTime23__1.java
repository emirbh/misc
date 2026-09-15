package iso20022.auth030.asic;

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
import iso20022.auth030.asic.meta.ClearingPartyAndTime23__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ClearingPartyAndTime23__1", builder=ClearingPartyAndTime23__1.ClearingPartyAndTime23__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="ClearingPartyAndTime23__1", model="iso20022", builder=ClearingPartyAndTime23__1.ClearingPartyAndTime23__1BuilderImpl.class, version="${project.version}")
public interface ClearingPartyAndTime23__1 extends RosettaModelObject {

	ClearingPartyAndTime23__1Meta metaData = new ClearingPartyAndTime23__1Meta();

	/*********************** Getter Methods  ***********************/
	OrganisationIdentification15Choice__1 getCcp();

	/*********************** Build Methods  ***********************/
	ClearingPartyAndTime23__1 build();
	
	ClearingPartyAndTime23__1.ClearingPartyAndTime23__1Builder toBuilder();
	
	static ClearingPartyAndTime23__1.ClearingPartyAndTime23__1Builder builder() {
		return new ClearingPartyAndTime23__1.ClearingPartyAndTime23__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ClearingPartyAndTime23__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ClearingPartyAndTime23__1> getType() {
		return ClearingPartyAndTime23__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("ccp"), processor, OrganisationIdentification15Choice__1.class, getCcp());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ClearingPartyAndTime23__1Builder extends ClearingPartyAndTime23__1, RosettaModelObjectBuilder {
		OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getOrCreateCcp();
		@Override
		OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getCcp();
		ClearingPartyAndTime23__1.ClearingPartyAndTime23__1Builder setCcp(OrganisationIdentification15Choice__1 ccp);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("ccp"), processor, OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder.class, getCcp());
		}
		

		ClearingPartyAndTime23__1.ClearingPartyAndTime23__1Builder prune();
	}

	/*********************** Immutable Implementation of ClearingPartyAndTime23__1  ***********************/
	class ClearingPartyAndTime23__1Impl implements ClearingPartyAndTime23__1 {
		private final OrganisationIdentification15Choice__1 ccp;
		
		protected ClearingPartyAndTime23__1Impl(ClearingPartyAndTime23__1.ClearingPartyAndTime23__1Builder builder) {
			this.ccp = ofNullable(builder.getCcp()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("ccp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ccp")
		public OrganisationIdentification15Choice__1 getCcp() {
			return ccp;
		}
		
		@Override
		public ClearingPartyAndTime23__1 build() {
			return this;
		}
		
		@Override
		public ClearingPartyAndTime23__1.ClearingPartyAndTime23__1Builder toBuilder() {
			ClearingPartyAndTime23__1.ClearingPartyAndTime23__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ClearingPartyAndTime23__1.ClearingPartyAndTime23__1Builder builder) {
			ofNullable(getCcp()).ifPresent(builder::setCcp);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingPartyAndTime23__1 _that = getType().cast(o);
		
			if (!Objects.equals(ccp, _that.getCcp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ccp != null ? ccp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingPartyAndTime23__1 {" +
				"ccp=" + this.ccp +
			'}';
		}
	}

	/*********************** Builder Implementation of ClearingPartyAndTime23__1  ***********************/
	class ClearingPartyAndTime23__1BuilderImpl implements ClearingPartyAndTime23__1.ClearingPartyAndTime23__1Builder {
	
		protected OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder ccp;
		
		@Override
		@RosettaAttribute("ccp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ccp")
		public OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getCcp() {
			return ccp;
		}
		
		@Override
		public OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getOrCreateCcp() {
			OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder result;
			if (ccp!=null) {
				result = ccp;
			}
			else {
				result = ccp = OrganisationIdentification15Choice__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("ccp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ccp")
		@Override
		public ClearingPartyAndTime23__1.ClearingPartyAndTime23__1Builder setCcp(OrganisationIdentification15Choice__1 _ccp) {
			this.ccp = _ccp == null ? null : _ccp.toBuilder();
			return this;
		}
		
		@Override
		public ClearingPartyAndTime23__1 build() {
			return new ClearingPartyAndTime23__1.ClearingPartyAndTime23__1Impl(this);
		}
		
		@Override
		public ClearingPartyAndTime23__1.ClearingPartyAndTime23__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingPartyAndTime23__1.ClearingPartyAndTime23__1Builder prune() {
			if (ccp!=null && !ccp.prune().hasData()) ccp = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCcp()!=null && getCcp().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingPartyAndTime23__1.ClearingPartyAndTime23__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ClearingPartyAndTime23__1.ClearingPartyAndTime23__1Builder o = (ClearingPartyAndTime23__1.ClearingPartyAndTime23__1Builder) other;
			
			merger.mergeRosetta(getCcp(), o.getCcp(), this::setCcp);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingPartyAndTime23__1 _that = getType().cast(o);
		
			if (!Objects.equals(ccp, _that.getCcp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ccp != null ? ccp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingPartyAndTime23__1Builder {" +
				"ccp=" + this.ccp +
			'}';
		}
	}
}
